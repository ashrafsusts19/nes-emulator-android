package com.ashrafsusts19.nesemulator;

public abstract class MapperA {
    public MapperA(short prgBanks, short chrBanks){
        this.nPRGBanks = prgBanks;
        this.nCHRBanks = chrBanks;
        this.reset();
    }

    public abstract boolean cpuMapRead(int addr, long[] mapped_addr);
    public abstract boolean cpuMapWrite(int addr, long[] mapped_addr, short data);
    public abstract boolean ppuMapRead(int addr, long[] mapped_addr);
    public abstract boolean ppuMapWrite(int addr, long[] mapped_addr);
    public abstract void reset();

    public short nPRGBanks = 0, nCHRBanks = 0;
}
