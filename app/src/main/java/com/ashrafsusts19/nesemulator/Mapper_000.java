package com.ashrafsusts19.nesemulator;

public class Mapper_000 extends MapperA {
    public Mapper_000(short prgBanks, short chrBanks) {
        super(prgBanks, chrBanks);
    }

    private int ushort(int a){
        return a & 0xFFFF;
    }
    private short ubyte (short a){
        return (short) (a & 0xFF);
    }

    @Override
    public boolean cpuMapRead(int addr, long[] mapped_addr) {
        addr = ushort(addr);
        if (addr >= 0x8000 && addr <= 0xFFFF){
            mapped_addr[0] = addr & (this.nPRGBanks > 1 ? 0x7FFF : 0x3FFF);
            return true;
        }

        return false;
    }

    @Override
    public boolean cpuMapWrite(int addr, long[] mapped_addr, short data) {
        addr = ushort(addr);
        data = ubyte(data);
        if (addr >= 0x8000 && addr <= 0xFFFF)
        {
            mapped_addr[0] = addr & (this.nPRGBanks > 1 ? 0x7FFF : 0x3FFF);
            return true;
        }
        return false;
    }

    @Override
    public boolean ppuMapRead(int addr, long[] mapped_addr) {
        addr = ushort(addr);
        if (addr >= 0x0000 && addr <= 0x1FFF){
            mapped_addr[0] = addr;
            return true;
        }
        return false;
    }

    @Override
    public boolean ppuMapWrite(int addr, long[] mapped_addr) {
        addr = ushort(addr);
        if (addr >= 0x0000 && addr <= 0x1FFF)
        {
            if (nCHRBanks == 0)
            {
                // Treat as RAM
                mapped_addr[0] = addr;
                return true;
            }
        }
        return false;
    }

    @Override
    public void reset() {

    }
}
