package com.ashrafsusts19.nesemulator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Cartridge extends CartridgeA {
    private class Header {
        char[] name;
        short prg_rom_chunks, chr_rom_chunks;
        short mapper1, mapper2;
        short prg_ram_size;
        short tv_system1, tv_system2;
        char[] unused;
        public Header(byte[] header) {
            this.name = new char[4];
            this.unused = new char[5];
            for (int i = 0; i < 4; i++){
                name[i] = (char) header[i];
            }
            prg_rom_chunks = (short) (0xFF & header[4]);
            chr_rom_chunks = (short) (0xFF & header[5]);
            mapper1 = (short) (0xFF & header[6]);
            mapper2 = (short) (0xFF & header[7]);
            prg_ram_size = (short) (0xFF & header[8]);
            tv_system1 = (short) (0xFF & header[9]);
            tv_system2 = (short) (0xFF & header[10]);
            for (int i = 0; i < 5; i++){
                unused[i] = (char) (0xFF & header[11 + i]);
            }
        }
    }

    public Cartridge(String sFileName) throws IOException {
        this.bImageValid = false;
        byte[] header = new byte[16];
        byte[] junk = new byte[512];
        InputStream cartFile = new FileInputStream(sFileName);
        cartFile.read(header);
        Header headerData = new Header(header);
        if ((headerData.mapper1 & 0x04) > 0){
            cartFile.read(junk);
        }
        this.nMapperID = ubyte((short) (((headerData.mapper2 >> 4) << 4) | (headerData.mapper1 >> 4)));
        this.mirror = (headerData.mapper1 & 0x01) > 0 ? CartridgeA.MIRROR.VERTICAL : CartridgeA.MIRROR.HORIZONTAL;
        short nFileType = 1;
        if (nFileType == 0){

        }
        else if (nFileType == 1){
            this.nPRGBanks = headerData.prg_rom_chunks;
            this.vPRGMemory = new short[this.nPRGBanks * 16384];
            byte[] vPRGMtemp = new byte[this.vPRGMemory.length];
            cartFile.read(vPRGMtemp);
            for (int i = 0; i < this.vPRGMemory.length; i++){
                this.vPRGMemory[i] = (short) (0xFF & vPRGMtemp[i]);
            }

            this.nCHRBanks = headerData.chr_rom_chunks;
            if (nCHRBanks == 0)
            {
                this.vCHRMemory = new short[8192];
            }
            else {
                this.vCHRMemory = new short[this.nCHRBanks * 8192];
            }
            byte[] vCHRMtemp = new byte[this.vCHRMemory.length];
            cartFile.read(vCHRMtemp);
            for (int i = 0; i < this.vCHRMemory.length; i++){
                this.vCHRMemory[i] = (short) (0xFF & vCHRMtemp[i]);
            }
        }
        else if (nFileType == 2){

        }
//        System.out.println(this.vPRGMemory.length);
//        System.out.println(this.vCHRMemory.length);
//        System.out.println(this.nMapperID);
//        System.out.println(this.nPRGBanks);
//        System.out.println(this.nCHRBanks);
        for (int i = 0; i < header.length; i++){
            //System.out.println(String.format("%x", (short) (0xFF & header[i])));

        }

        switch (this.nMapperID){
            case 0:
                pMapper = new Mapper_000(this.nPRGBanks, this.nCHRBanks);
            default:
                //pMapper = new Mapper_000(this.nPRGBanks, this.nCHRBanks);
                break;
        }
        bImageValid = true;
        cartFile.close();
    }

    private int ushort(int a){
        return a & 0xFFFF;
    }
    private short ubyte (short a){
        return (short) (a & 0xFF);
    }

    @Override
    public boolean cpuRead(int addr, short[] data) {
        addr = ushort(addr);
        long[] mapped_addr = new long[1];
        if (pMapper.cpuMapRead(addr, mapped_addr)){
            data[0] = this.vPRGMemory[(int) mapped_addr[0]];
            return true;
        }
        return false;
    }

    @Override
    public boolean cpuWrite(int addr, short data) {
        addr = ushort(addr);
        data = ubyte(data);
        long[] mapped_addr = new long[1];
        if (pMapper.cpuMapWrite(addr, mapped_addr, data)){
            this.vPRGMemory[(int) mapped_addr[0]] = data;
            return true;
        }
        return false;
    }

    @Override
    public boolean ppuRead(int addr, short[] data) {
        addr = ushort(addr);
        long[] mapped_addr = new long[1];
        if (pMapper.ppuMapRead(addr, mapped_addr))
        {
            data[0] = vCHRMemory[(int) mapped_addr[0]];
            return true;
        }
        return false;
    }

    @Override
    public boolean ppuWrite(int addr, short data) {
        addr = ushort(addr);
        data = ubyte(data);
        long[] mapped_addr = new long[1];
        if (pMapper.ppuMapWrite(addr, mapped_addr)){
            this.vCHRMemory[(int) mapped_addr[0]] = data;
            return true;
        }
        return false;
    }

    @Override
    public boolean imageValid() {
        return this.bImageValid;
    }

    @Override
    public void reset() {

    }
}
