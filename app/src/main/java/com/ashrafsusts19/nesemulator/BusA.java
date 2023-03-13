package com.ashrafsusts19.nesemulator;

public abstract class BusA {
    public Olc6502 cpu;
    public Olc2C02 ppu;
    public Cartridge cart;

    public short[] cpuRAM = new short[2 * 1024];
    public short[] controller = new short[2];
    public short[] controller_state = new short[2];

    public abstract void cpuWrite(int addr, short data);
    public abstract short cpuRead(int addr);
    public abstract short cpuRead(int addr, boolean readOnly);

    public abstract void insertCartridge(Cartridge cartridge);
    public abstract void reset();
    public abstract void clock();

    public long nSystemClockCounter = 0;

    short dma_page = 0x00;
    short dma_addr = 0x00;
    short dma_data = 0x00;

    boolean dma_dummy = true;

    boolean dma_transfer = false;

}
