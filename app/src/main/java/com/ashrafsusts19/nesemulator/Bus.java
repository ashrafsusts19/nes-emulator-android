package com.ashrafsusts19.nesemulator;

public class Bus extends BusA {

    public Bus() {
        for (int i = 0; i < cpuRAM.length; i++){
            cpuRAM[i] = (short) 0x00;
        }
        cpu = new Olc6502();
        cpu.connectBus(this);
        ppu = new Olc2C02();
    }

    private int ushort(int a){
        return a & 0xFFFF;
    }
    private short ubyte (short a){
        return (short) (a & 0xFF);
    }

    @Override
    public void cpuWrite(int addr, short data) {
        addr = ushort(addr);
        data = ubyte(data);
        if (cart.cpuWrite(addr, data)){

        }
        else if (addr >= 0x0000 && addr <= 0x1FFF){
            cpuRAM[addr & 0x07FF] = data;
        }
        else if (addr >= 0x2000 && addr <= 0x3FFF){
            ppu.cpuWrite(addr & 0x0007, data);
        }
        else if (addr == 0x4014)
        {
            this.dma_page = data;
            this.dma_addr = 0x00;
            this.dma_transfer = true;
        }
        else if (addr >= 0x4016 && addr <= 0x4017){
            controller_state[addr & 0x0001] = controller[addr & 0x0001];
        }
    }

    @Override
    public short cpuRead(int addr) {
        addr = ushort(addr);
        short data = this.cpuRead(addr, false);
        return ubyte(data);
    }

    @Override
    public short cpuRead(int addr, boolean readOnly) {
        addr = ushort(addr);
        short data = 0x00;
        short[] cdata = new short[1];
        if (cart.cpuRead(addr, cdata)){
            data = cdata[0];
        }
        else if (addr >= 0x0000 && addr <= 0x1FFF)
        {
            data = cpuRAM[addr & 0x07FF];
        }
        else if (addr >= 0x2000 && addr <= 0x3FFF){
            data = ppu.cpuRead(addr & 0x0007, readOnly);
        }
        else if (addr >= 0x4016 && addr <= 0x4017){
            data = (short) ((controller_state[addr & 0x0001] & 0x80) > 0 ? 1: 0);
            controller_state[addr & 0x0001] <<= 1;
        }

        return ubyte(data);
    }

    @Override
    public void insertCartridge(Cartridge cartridge) {
        this.cart = cartridge;
        ppu.ConnectCartridge(cartridge);
    }

    @Override
    public void reset() {
        this.cart.reset();
        this.cpu.reset();
        this.ppu.reset();
        this.nSystemClockCounter = 0;
    }

    @Override
    public void clock() {
        ppu.clock();
        if (this.nSystemClockCounter % 3 == 0){
            if (this.dma_transfer)
            {
                if (this.dma_dummy)
                {
                    if (this.nSystemClockCounter % 2 == 1)
                    {
                        this.dma_dummy = false;
                    }
                }
                else
                {
                    if (this.nSystemClockCounter % 2 == 0)
                    {
                        this.dma_data = cpuRead(dma_page << 8 | dma_addr);
                    }
                    else
                    {
                        this.ppu.pOAMSet(dma_addr, dma_data);
                        this.dma_addr = ubyte((short) (this.dma_addr + 1));
                        if (this.dma_addr == 0x00)
                        {
                            this.dma_transfer = false;
                            this.dma_dummy = true;
                        }
                    }
                }
            }
            else
            {
                this.cpu.clock();
            }
        }
        if (this.ppu.nmi){
            this.ppu.nmi = false;
            this.cpu.nmi();
        }
        this.nSystemClockCounter++;
    }
}
