package com.ashrafsusts19.nesemulator;

public abstract class CartridgeA {
    enum MIRROR {
        HORIZONTAL,
        VERTICAL,
        ONESCREEN_LO,
        ONESCREEN_HI;
    }

    boolean bImageValid = false;
    short nMapperID = 0;
    MIRROR mirror = MIRROR.HORIZONTAL;
    short nPRGBanks = 0;
    short nCHRBanks = 0;

    public short[] vPRGMemory;
    public short[] vCHRMemory;

    MapperA pMapper;
    
    public abstract boolean cpuRead(int addr, short[] data);
    public abstract boolean cpuWrite(int addr, short data);

    public abstract boolean ppuRead(int addr, short[] data);
    public abstract boolean ppuWrite(int addr, short data);

    public abstract boolean imageValid();

    public abstract void reset();
}
