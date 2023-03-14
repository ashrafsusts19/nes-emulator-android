package com.ashrafsusts19.nesemulator;

import java.util.Random;

public class Olc2C02 extends Olc2C02A {
    Random rnd;
    public Olc2C02(){
        this.rnd = new Random();
        this.tblName = new short[2][1024];
        this.tblPalette = new short[32];
        this.tblPattern = new short[2][4096];
        this.palScreen = new Olc2C02A.Pixel[0x40];
        palScreen[0x00] = new Olc2C02A.Pixel(84, 84, 84);
        palScreen[0x01] = new Olc2C02A.Pixel(0, 30, 116);
        palScreen[0x02] = new Olc2C02A.Pixel(8, 16, 144);
        palScreen[0x03] = new Olc2C02A.Pixel(48, 0, 136);
        palScreen[0x04] = new Olc2C02A.Pixel(68, 0, 100);
        palScreen[0x05] = new Olc2C02A.Pixel(92, 0, 48);
        palScreen[0x06] = new Olc2C02A.Pixel(84, 4, 0);
        palScreen[0x07] = new Olc2C02A.Pixel(60, 24, 0);
        palScreen[0x08] = new Olc2C02A.Pixel(32, 42, 0);
        palScreen[0x09] = new Olc2C02A.Pixel(8, 58, 0);
        palScreen[0x0A] = new Olc2C02A.Pixel(0, 64, 0);
        palScreen[0x0B] = new Olc2C02A.Pixel(0, 60, 0);
        palScreen[0x0C] = new Olc2C02A.Pixel(0, 50, 60);
        palScreen[0x0D] = new Olc2C02A.Pixel(0, 0, 0);
        palScreen[0x0E] = new Olc2C02A.Pixel(0, 0, 0);
        palScreen[0x0F] = new Olc2C02A.Pixel(0, 0, 0);

        palScreen[0x10] = new Olc2C02A.Pixel(152, 150, 152);
        palScreen[0x11] = new Olc2C02A.Pixel(8, 76, 196);
        palScreen[0x12] = new Olc2C02A.Pixel(48, 50, 236);
        palScreen[0x13] = new Olc2C02A.Pixel(92, 30, 228);
        palScreen[0x14] = new Olc2C02A.Pixel(136, 20, 176);
        palScreen[0x15] = new Olc2C02A.Pixel(160, 20, 100);
        palScreen[0x16] = new Olc2C02A.Pixel(152, 34, 32);
        palScreen[0x17] = new Olc2C02A.Pixel(120, 60, 0);
        palScreen[0x18] = new Olc2C02A.Pixel(84, 90, 0);
        palScreen[0x19] = new Olc2C02A.Pixel(40, 114, 0);
        palScreen[0x1A] = new Olc2C02A.Pixel(8, 124, 0);
        palScreen[0x1B] = new Olc2C02A.Pixel(0, 118, 40);
        palScreen[0x1C] = new Olc2C02A.Pixel(0, 102, 120);
        palScreen[0x1D] = new Olc2C02A.Pixel(0, 0, 0);
        palScreen[0x1E] = new Olc2C02A.Pixel(0, 0, 0);
        palScreen[0x1F] = new Olc2C02A.Pixel(0, 0, 0);

        palScreen[0x20] = new Olc2C02A.Pixel(236, 238, 236);
        palScreen[0x21] = new Olc2C02A.Pixel(76, 154, 236);
        palScreen[0x22] = new Olc2C02A.Pixel(120, 124, 236);
        palScreen[0x23] = new Olc2C02A.Pixel(176, 98, 236);
        palScreen[0x24] = new Olc2C02A.Pixel(228, 84, 236);
        palScreen[0x25] = new Olc2C02A.Pixel(236, 88, 180);
        palScreen[0x26] = new Olc2C02A.Pixel(236, 106, 100);
        palScreen[0x27] = new Olc2C02A.Pixel(212, 136, 32);
        palScreen[0x28] = new Olc2C02A.Pixel(160, 170, 0);
        palScreen[0x29] = new Olc2C02A.Pixel(116, 196, 0);
        palScreen[0x2A] = new Olc2C02A.Pixel(76, 208, 32);
        palScreen[0x2B] = new Olc2C02A.Pixel(56, 204, 108);
        palScreen[0x2C] = new Olc2C02A.Pixel(56, 180, 204);
        palScreen[0x2D] = new Olc2C02A.Pixel(60, 60, 60);
        palScreen[0x2E] = new Olc2C02A.Pixel(0, 0, 0);
        palScreen[0x2F] = new Olc2C02A.Pixel(0, 0, 0);

        palScreen[0x30] = new Olc2C02A.Pixel(236, 238, 236);
        palScreen[0x31] = new Olc2C02A.Pixel(168, 204, 236);
        palScreen[0x32] = new Olc2C02A.Pixel(188, 188, 236);
        palScreen[0x33] = new Olc2C02A.Pixel(212, 178, 236);
        palScreen[0x34] = new Olc2C02A.Pixel(236, 174, 236);
        palScreen[0x35] = new Olc2C02A.Pixel(236, 174, 212);
        palScreen[0x36] = new Olc2C02A.Pixel(236, 180, 176);
        palScreen[0x37] = new Olc2C02A.Pixel(228, 196, 144);
        palScreen[0x38] = new Olc2C02A.Pixel(204, 210, 120);
        palScreen[0x39] = new Olc2C02A.Pixel(180, 222, 120);
        palScreen[0x3A] = new Olc2C02A.Pixel(168, 226, 144);
        palScreen[0x3B] = new Olc2C02A.Pixel(152, 226, 180);
        palScreen[0x3C] = new Olc2C02A.Pixel(160, 214, 228);
        palScreen[0x3D] = new Olc2C02A.Pixel(160, 162, 160);
        palScreen[0x3E] = new Olc2C02A.Pixel(0, 0, 0);
        palScreen[0x3F] = new Olc2C02A.Pixel(0, 0, 0);

        for (int i = 0; i < 64; i++){
            this.OAM[i] = new Olc2C02A.sObjectAttributeEntry();
        }
        for (int i = 0; i < 8; i++){
            this.spriteScanline[i] = new Olc2C02A.sObjectAttributeEntry();
        }

        this.sprNameTable[0] = new Olc2C02A.Sprite(256, 240);
        this.sprNameTable[1] = new Olc2C02A.Sprite(256, 240);
        this.sprPatternTable[0] = new Olc2C02A.Sprite(128, 128);
        this.sprPatternTable[1] = new Olc2C02A.Sprite(128, 128);

        this.status = new Olc2C02A.Status();
        this.mask = new Olc2C02A.Mask();
        this.control = new Olc2C02A.Control();
        this.vram_addr = new Olc2C02A.Loopy_register();
        this.tram_addr = new Olc2C02A.Loopy_register();
    }

    private int ushort(int a){
        return a & 0xFFFF;
    }
    private short ubyte (short a){
        return (short) (a & 0xFF);
    }

    public short flipbyte(short b)
    {
        short c = 0;
        for (int i = 0; i < 8; i++){
            if ((b & (1 << i)) > 0){
                c |= (1 << (7 - i));
            }
        }
//        b = (b & 0xF0) >> 4 | (b & 0x0F) << 4;
//        b = (b & 0xCC) >> 2 | (b & 0x33) << 2;
//        b = (b & 0xAA) >> 1 | (b & 0x55) << 1;
        return c;
    }

    public short pOAMGet(short index){
        index = ubyte(index);
        short data = 0x00;
        int OAMind = index / 4;
        switch (index % 4){
            case 0:
                data = this.OAM[OAMind].y;
                break;
            case 1:
                data = this.OAM[OAMind].id;
                break;
            case 2:
                data = this.OAM[OAMind].attribute;
                break;
            case 3:
                data = this.OAM[OAMind].x;
                break;
        }
        data = ubyte(data);
        return data;
    }

    public void pOAMSet(short index, short data){
        index = ubyte(index);
        data = ubyte(data);
        int OAMind = index / 4;
        switch (index % 4){
            case 0:
                this.OAM[OAMind].y = data;
                break;
            case 1:
                this.OAM[OAMind].id = data;
                break;
            case 2:
                this.OAM[OAMind].attribute = data;
                break;
            case 3:
                this.OAM[OAMind].x = data;
                break;
        }
    }

    public void IncrementScrollX()
    {
        if (mask.get(REGISTERS.RENDER_BACKGROUND) > 0 || mask.get(REGISTERS.RENDER_SPRITES) > 0)
        {
            // A single name table is 32x30 tiles. As we increment horizontally
            // we may cross into a neighbouring nametable, or wrap around to
            // a neighbouring nametable
            if (vram_addr.get(REGISTERS.COARSE_X) == 31)
            {
                // Leaving nametable so wrap address round
                vram_addr.set(REGISTERS.COARSE_X, 0);
                // Flip target nametable bit
                vram_addr.set(REGISTERS.NAMETABLE_X, ushort(~vram_addr.get(REGISTERS.NAMETABLE_X)));
            }
            else
            {
                // Staying in current nametable, so just increment
                vram_addr.set(REGISTERS.COARSE_X,
                        ushort(vram_addr.get(REGISTERS.COARSE_X) + 1));
            }
        }
    }

    public void IncrementScrollY()
    {
        // Ony if rendering is enabled
        if (mask.get(REGISTERS.RENDER_BACKGROUND) > 0 || mask.get(REGISTERS.RENDER_SPRITES) > 0)
        {
            // If possible, just increment the fine y offset
            if (vram_addr.get(REGISTERS.FINE_Y) < 7)
            {
                vram_addr.set(REGISTERS.FINE_Y,
                        ushort(vram_addr.get(REGISTERS.FINE_Y) + 1));
            }
            else
            {
                // Reset fine y offset
                vram_addr.set(REGISTERS.FINE_Y, 0);

                // Check if we need to swap vertical nametable targets
                if (vram_addr.get(REGISTERS.COARSE_Y) == 29)
                {
                    // We do, so reset coarse y offset
                    vram_addr.set(REGISTERS.COARSE_Y, 0);
                    // And flip the target nametable bit
                    vram_addr.set(REGISTERS.NAMETABLE_Y,
                            ushort(~vram_addr.get(REGISTERS.NAMETABLE_Y))) ;
                }
                else if (vram_addr.get(REGISTERS.COARSE_Y) == 31)
                {
                    // In case the pointer is in the attribute memory, we
                    // just wrap around the current nametable
                    vram_addr.set(REGISTERS.COARSE_Y, 0);
                }
                else
                {
                    // None of the above boundary/wrapping conditions apply
                    // so just increment the coarse y offset
                    vram_addr.set(REGISTERS.COARSE_Y,
                            ushort(vram_addr.get(REGISTERS.COARSE_Y) + 1));
                }
            }
        }
    }

    public void TransferAddressX()
    {
        // Ony if rendering is enabled
        if (mask.get(REGISTERS.RENDER_BACKGROUND) > 0 || mask.get(REGISTERS.RENDER_SPRITES) > 0)
        {
            vram_addr.set(REGISTERS.NAMETABLE_X, tram_addr.get(REGISTERS.NAMETABLE_X));
            vram_addr.set(REGISTERS.COARSE_X, tram_addr.get(REGISTERS.COARSE_X));
        }
    }

    public void TransferAddressY()
    {
        // Ony if rendering is enabled
        if (mask.get(REGISTERS.RENDER_BACKGROUND) > 0 || mask.get(REGISTERS.RENDER_SPRITES) > 0)
        {
            vram_addr.set(REGISTERS.FINE_Y, tram_addr.get(REGISTERS.FINE_Y));
            vram_addr.set(REGISTERS.NAMETABLE_Y, tram_addr.get(REGISTERS.NAMETABLE_Y));
            vram_addr.set(REGISTERS.COARSE_Y, tram_addr.get(REGISTERS.COARSE_Y));
        }
    }

    public void LoadBackgroundShifters()
    {
        bg_shifter_pattern_lo = (bg_shifter_pattern_lo & 0xFF00) | bg_next_tile_lsb;
        bg_shifter_pattern_hi = (bg_shifter_pattern_hi & 0xFF00) | bg_next_tile_msb;

        bg_shifter_attrib_lo  = (bg_shifter_attrib_lo & 0xFF00) | ((bg_next_tile_attrib & 0b01) > 0 ? 0xFF : 0x00);
        bg_shifter_attrib_hi  = (bg_shifter_attrib_hi & 0xFF00) | ((bg_next_tile_attrib & 0b10) > 0 ? 0xFF : 0x00);
    }

    public void UpdateShifters()
    {
        if (mask.get(REGISTERS.RENDER_BACKGROUND) > 0)
        {
            // Shifting background tile pattern row
            bg_shifter_pattern_lo = ushort(bg_shifter_pattern_lo << 1);
            bg_shifter_pattern_hi = ushort(bg_shifter_pattern_hi << 1);

            // Shifting palette attributes by 1
            bg_shifter_attrib_lo = ushort(bg_shifter_attrib_lo << 1);
            bg_shifter_attrib_hi = ushort(bg_shifter_attrib_hi << 1);
        }
        if (mask.get(REGISTERS.RENDER_SPRITES) > 0 && cycle >= 1 && cycle < 258)
        {
            for (int i = 0; i < sprite_count; i++)
            {
                if (spriteScanline[i].x > 0)
                {
                    spriteScanline[i].x = ubyte((short) (spriteScanline[i].x - 1));
                }
                else
                {
                    sprite_shifter_pattern_lo[i] = ubyte((short) (sprite_shifter_pattern_lo[i] << 1));
                    sprite_shifter_pattern_hi[i] = ubyte((short) (sprite_shifter_pattern_hi[i] << 1));
                }
            }
        }
    }


    public Olc2C02A.Pixel getColourFromPaletteRam(short palette, short pixel){
        palette = ubyte(palette);
        pixel = ubyte(pixel);
        return this.palScreen[ppuRead(0x3F00 + (palette << 2) + pixel) & 0x3F];
    }

    @Override
    public Olc2C02A.Sprite getScreen() {
        return this.sprScreen;
    }

    @Override
    public Olc2C02A.Sprite getNameTable(short i) {
        i = ubyte(i);
        return this.sprNameTable[i];
    }

    @Override
    public Olc2C02A.Sprite getPatternTable(short i, short palette) {
        i = ubyte(i);
        palette = ubyte(palette);
        for (int nTileY = 0; nTileY < 16; nTileY++){
            for (int nTileX = 0; nTileX < 16; nTileX++){
                int nOffset = ushort(nTileY * 256 + nTileX * 16);
                for (int row = 0; row < 8; row++){
                    short tile_lsb = ppuRead(ushort(i * 0x1000 + nOffset + row + 0x0000));
                    short tile_msb = ppuRead(ushort(i * 0x1000 + nOffset + row + 0x0008));
                    for (int col = 0; col < 8; col++){
                        short pixel = ubyte((short) ((tile_lsb & 0x01) << 1 | (tile_msb & 0x01)));
                        tile_lsb >>= 1;
                        tile_msb >>= 1;
                        this.sprPatternTable[i].setPixel(
                                nTileX * 8 + (7 - col),
                                nTileY * 8 + row,
                                getColourFromPaletteRam(palette, pixel)
                        );
                    }
                }
            }
        }
        return this.sprPatternTable[i];
    }

    @Override
    public short cpuRead(int addr, boolean readonly) {
        addr = ushort(addr);
        short data = 0x00;
        if (readonly)
        {
            switch (addr)
            {
                case 0x0000: // Control
                    data = control.get(REGISTERS.REG);
                    break;
                case 0x0001: // Mask
                    data = mask.get(REGISTERS.REG);
                    break;
                case 0x0002: // Status
                    data = status.get(REGISTERS.REG);
                    break;
                case 0x0003: // OAM Address
                    break;
                case 0x0004: // OAM Data
                    break;
                case 0x0005: // Scroll
                    break;
                case 0x0006: // PPU Address
                    break;
                case 0x0007: // PPU Data
                    break;
            }
        }
        else {
            switch (addr)
            {
                case 0x0000: // Control
                    break;
                case 0x0001: // Mask
                    break;
                case 0x0002: // Status
                    data = ubyte((short) ((this.status.get(REGISTERS.REG) & 0xE0) | (this.ppu_data_buffer & 0x1F)));
                    this.status.set(REGISTERS.VERTICAL_BLANK, (short) 0);
                    this.address_latch = 0;
                    break;
                case 0x0003: // OAM Address
                    break;
                case 0x0004: // OAM Data
                    data = this.pOAMGet(this.oam_addr);
                    break;
                case 0x0005: // Scroll
                    break;
                case 0x0006: // PPU Address
                    break;
                case 0x0007: // PPU Data
                    data = this.ppu_data_buffer;
                    this.ppu_data_buffer = this.ppuRead(this.vram_addr.get(REGISTERS.REG));
                    if (this.vram_addr.get(REGISTERS.REG) >= 0x3F00){
                        data = this.ppu_data_buffer;
                    }
                    vram_addr.set(REGISTERS.REG,
                            ushort((this.vram_addr.get(REGISTERS.REG) +
                                    (control.get(REGISTERS.INCREMENT_MODE) > 0? 32 : 1))));
                    break;
            }
        }
        return ubyte(data);
    }

    @Override
    public short cpuRead(int addr) {
        addr = ushort(addr);
        short data = cpuRead(addr, false);
        return data;
    }

    @Override
    public void cpuWrite(int addr, short data) {
        addr = ushort(addr);
        data = ubyte(data);
        switch (addr)
        {
            case 0x0000: // Control
                control.set(REGISTERS.REG, data);
                tram_addr.set(REGISTERS.NAMETABLE_X, control.get(REGISTERS.NAMETABLE_X));
                tram_addr.set(REGISTERS.NAMETABLE_Y, control.get(REGISTERS.NAMETABLE_Y));
                break;
            case 0x0001: // Mask
                mask.set(REGISTERS.REG, data);
                break;
            case 0x0002: // Status
                break;
            case 0x0003: // OAM Address
                this.oam_addr = data;
                break;
            case 0x0004: // OAM Data
                this.pOAMSet(this.oam_addr, data);
                break;
            case 0x0005: // Scroll
                if (this.address_latch == 0)
                {
                    this.fine_x = ubyte((short) (data & 0x07));
                    this.tram_addr.set(REGISTERS.COARSE_X, ushort((data >> 3)));
                    this.address_latch = 1;
                }
                else
                {
                    this.tram_addr.set(REGISTERS.FINE_Y, ushort((data & 0x07)));
                    this.tram_addr.set(REGISTERS.COARSE_Y, ushort((data >> 3)));
                    this.address_latch = 0;
                }
                break;
            case 0x0006: // PPU Address
                if (this.address_latch == 0){
                    this.tram_addr.set(REGISTERS.REG, ushort(
                            ((ushort((data & 0x3F) << 8) | (tram_addr.get(REGISTERS.REG) & 0x00FF)))));
                    this.address_latch = 1;
                }
                else {
                    this.tram_addr.set(REGISTERS.REG,
                            ushort((this.tram_addr.get(REGISTERS.REG) & 0xFF00) | data));
                    this.vram_addr.set(REGISTERS.REG,
                            this.tram_addr.get(REGISTERS.REG));
                    this.address_latch = 0;
                }
                break;
            case 0x0007: // PPU Data
                this.ppuWrite(vram_addr.get(REGISTERS.REG), data);
                int treg = this.vram_addr.get(REGISTERS.REG);
                treg += control.get(REGISTERS.INCREMENT_MODE) > 0? 32: 1;
                vram_addr.set(REGISTERS.REG, ushort(treg));
                break;
        }
    }

    @Override
    public short ppuRead(int addr, boolean readonly) {
        addr = ushort(addr);
        short data = 0x00;
        addr &= 0x3FFF;

        short[] cdata = new short[1];
        if (cart.ppuRead(addr, cdata)){
            data = cdata[0];
        }
        else if (addr >= 0x0000 && addr <= 0x1FFF){
            data = this.tblPattern[(addr & 0x1000) >> 12][addr & 0x0FFF];
        }
        else if (addr >= 0x2000 && addr <= 0x3EFF){
            addr &= 0x0FFF;
            if (this.cart.mirror == CartridgeA.MIRROR.VERTICAL){
                if (addr >= 0x0000 && addr <= 0x03FF)
                    data = tblName[0][addr & 0x03FF];
                if (addr >= 0x0400 && addr <= 0x07FF)
                    data = tblName[1][addr & 0x03FF];
                if (addr >= 0x0800 && addr <= 0x0BFF)
                    data = tblName[0][addr & 0x03FF];
                if (addr >= 0x0C00 && addr <= 0x0FFF)
                    data = tblName[1][addr & 0x03FF];
            }
            else if (this.cart.mirror == CartridgeA.MIRROR.HORIZONTAL){
                if (addr >= 0x0000 && addr <= 0x03FF)
                    data = tblName[0][addr & 0x03FF];
                if (addr >= 0x0400 && addr <= 0x07FF)
                    data = tblName[0][addr & 0x03FF];
                if (addr >= 0x0800 && addr <= 0x0BFF)
                    data = tblName[1][addr & 0x03FF];
                if (addr >= 0x0C00 && addr <= 0x0FFF)
                    data = tblName[1][addr & 0x03FF];
            }
        }
        else if (addr >= 0x3F00 && addr <= 0x3FFF){
            addr &= 0x001F;
            if (addr == 0x0010) addr = 0x0000;
            if (addr == 0x0014) addr = 0x0004;
            if (addr == 0x0018) addr = 0x0008;
            if (addr == 0x001C) addr = 0x000C;
            data = ubyte((short) (tblPalette[addr] & (mask.get(REGISTERS.GRAYSCALE) > 0 ? 0x30 : 0x3F)));
        }

        return ubyte(data);
    }

    @Override
    public short ppuRead(int addr) {
        addr = ushort(addr);
        short data = ppuRead(addr, false);
        return data;
    }

    @Override
    public void ppuWrite(int addr, short data) {
        addr = ushort(addr);
        data = ubyte(data);
        addr &= 0x3FFF;
        if (cart.ppuWrite(addr, data)){

        }
        else if (addr >= 0x0000 && addr <= 0x1FFF){
            this.tblPattern[(addr & 0x1000) >> 12][addr & 0x0FFF] = data;
        }
        else if (addr >= 0x2000 && addr <= 0x3EFF){
            addr &= 0x0FFF;
            if (this.cart.mirror == CartridgeA.MIRROR.VERTICAL){
                if (addr >= 0x0000 && addr <= 0x03FF)
                    tblName[0][addr & 0x03FF] = data;
                if (addr >= 0x0400 && addr <= 0x07FF)
                    tblName[1][addr & 0x03FF] = data;
                if (addr >= 0x0800 && addr <= 0x0BFF)
                    tblName[0][addr & 0x03FF] = data;
                if (addr >= 0x0C00 && addr <= 0x0FFF)
                    tblName[1][addr & 0x03FF] = data;
            }
            else if (this.cart.mirror == CartridgeA.MIRROR.HORIZONTAL){
                if (addr >= 0x0000 && addr <= 0x03FF)
                    tblName[0][addr & 0x03FF] = data;
                if (addr >= 0x0400 && addr <= 0x07FF)
                    tblName[0][addr & 0x03FF] = data;
                if (addr >= 0x0800 && addr <= 0x0BFF)
                    tblName[1][addr & 0x03FF] = data;
                if (addr >= 0x0C00 && addr <= 0x0FFF)
                    tblName[1][addr & 0x03FF] = data;
            }
        }
        else if (addr >= 0x3F00 && addr <= 0x3FFF){
            addr &= 0x001F;
            if (addr == 0x0010) addr = 0x0000;
            if (addr == 0x0014) addr = 0x0004;
            if (addr == 0x0018) addr = 0x0008;
            if (addr == 0x001C) addr = 0x000C;
            tblPalette[addr] = data;
        }
    }

    @Override
    public void ConnectCartridge(Cartridge cartridge) {
        this.cart = cartridge;
    }

    @Override
    public void clock() {
        if (this.scanline >= -1 && this.scanline < 240){
            if (this.scanline == 0 && this.cycle == 0){
                this.cycle = 1;
            }
            if (this.scanline == -1 && this.cycle == 1){
                this.status.set(REGISTERS.VERTICAL_BLANK, (short)  0);

                status.set(REGISTERS.SPRITE_OVERFLOW, (short) 0);

                status.set(REGISTERS.SPRITE_ZERO_HIT, (short) 0);

                for (int i = 0; i < 8; i++)
                {
                    sprite_shifter_pattern_lo[i] = 0;
                    sprite_shifter_pattern_hi[i] = 0;
                }
            }
            if ((this.cycle >= 2 && this.cycle < 258) || (this.cycle >= 321 && this.cycle < 338)){
                this.UpdateShifters();
                switch ((this.cycle - 1) % 8){
                    case 0:
                        this.LoadBackgroundShifters();
                        this.bg_next_tile_id = this.ppuRead(0x2000 |
                                (vram_addr.get(REGISTERS.REG) & 0x0FFF));
                        break;
                    case 2:
                        bg_next_tile_attrib = ppuRead((0x23C0 | ushort(vram_addr.get(REGISTERS.NAMETABLE_Y) << 11)
                                | ushort(vram_addr.get(REGISTERS.NAMETABLE_X) << 10)
                                | ushort((vram_addr.get(REGISTERS.COARSE_Y) >> 2) << 3)
                                | ushort(vram_addr.get(REGISTERS.COARSE_X) >> 2)));
                        if ((vram_addr.get(REGISTERS.COARSE_Y) & 0x02) > 0) {
                            bg_next_tile_attrib >>= 4;
                        }
                        if ((vram_addr.get(REGISTERS.COARSE_X) & 0x02) > 0) {
                            bg_next_tile_attrib >>= 2;
                        }
                        bg_next_tile_attrib &= 0x03;
                        break;
                    case 4:
                        bg_next_tile_lsb = ppuRead(ushort(control.get(REGISTERS.PATTERN_BACKGROUND) << 12)
                                + ushort(ushort(bg_next_tile_id) << 4)
                                + (vram_addr.get(REGISTERS.FINE_Y)) + 0);
                        break;
                    case 6:
                        bg_next_tile_msb = ppuRead(ushort(control.get(REGISTERS.PATTERN_BACKGROUND) << 12)
                                + ushort(ushort(bg_next_tile_id) << 4)
                                + ushort((vram_addr.get(REGISTERS.FINE_Y)) + 8));
                        break;
                    case 7:
                        this.IncrementScrollX();
                        break;
                }
            }

            if (cycle == 256){
                this.IncrementScrollY();
            }

            if (cycle == 257){
                this.LoadBackgroundShifters();
                this.TransferAddressX();
            }

            if (cycle == 338 || cycle == 340)
            {
                bg_next_tile_id = ppuRead(0x2000 | (vram_addr.get(REGISTERS.REG) & 0x0FFF));
            }

            if (scanline == -1 && cycle >= 280 && cycle < 305){
                TransferAddressY();
            }

            //Foreground
            if (cycle == 257 && scanline >= 0) {
                for (int i = 0; i < 8; i++){
                    this.spriteScanline[i].y = 0xFF;
                    this.spriteScanline[i].attribute =0xFF;
                    this.spriteScanline[i].id = 0xFF;
                    this.spriteScanline[i].x = 0xFF;
                }

                sprite_count = 0;

                for (short i = 0; i < 8; i++) {
                    sprite_shifter_pattern_lo[i] = 0;
                    sprite_shifter_pattern_hi[i] = 0;
                }
                short nOAMEntry = 0;

                bSpriteZeroHitPossible = false;

                while (nOAMEntry < 64 && sprite_count < 9) {
                    int diff = ushort(ushort(scanline) - ushort(OAM[nOAMEntry].y));
                    if (diff >= 0 && diff < (control.get(REGISTERS.SPRITE_SIZE) > 0 ? 16 : 8)) {
                        if (sprite_count < 8) {
                            // Is this sprite sprite zero?
                            if (nOAMEntry == 0) {
                                bSpriteZeroHitPossible = true;
                            }
                            spriteScanline[sprite_count].x = OAM[nOAMEntry].x;
                            spriteScanline[sprite_count].y = OAM[nOAMEntry].y;
                            spriteScanline[sprite_count].attribute = OAM[nOAMEntry].attribute;
                            spriteScanline[sprite_count].id = OAM[nOAMEntry].id;
                            sprite_count++;
                        }
                    }
                    nOAMEntry++;
                } // End of sprite evaluation for next scanline

                // Set sprite overflow flag
                status.set(REGISTERS.SPRITE_OVERFLOW, (short) ((sprite_count > 8) ? 1 : 0));
            }

            if (cycle == 340)
            {
                for (short i = 0; i < sprite_count; i++) {
                    short sprite_pattern_bits_lo, sprite_pattern_bits_hi;
                    int sprite_pattern_addr_lo, sprite_pattern_addr_hi;

                    if (control.get(REGISTERS.SPRITE_SIZE) == 0) {
                        if ((spriteScanline[i].attribute & 0x80) == 0) {
                            sprite_pattern_addr_lo =
                                    ushort(ushort(control.get(REGISTERS.PATTERN_SPRITE) << 12)  // Which Pattern Table? 0KB or 4KB offset
                                            | ushort(spriteScanline[i].id << 4)  // Which Cell? Tile ID * 16 (16 bytes per tile)
                                            | ushort(scanline - spriteScanline[i].y)); // Which Row in cell? (0->7)

                        }
                        else {
                            // Sprite is flipped vertically, i.e. upside down
                            sprite_pattern_addr_lo =
                                    ushort(ushort(control.get(REGISTERS.PATTERN_SPRITE) << 12)  // Which Pattern Table? 0KB or 4KB offset
                                            | ushort(spriteScanline[i].id << 4)  // Which Cell? Tile ID * 16 (16 bytes per tile)
                                            | ushort(7 - (scanline - spriteScanline[i].y))); // Which Row in cell? (7->0)
                        }

                    }
                    else
                    {
                        // 8x16 Sprite Mode - The sprite attribute determines the pattern table
                        if ((spriteScanline[i].attribute & 0x80) == 0) {
                            // Sprite is NOT flipped vertically, i.e. normal
                            if (scanline - spriteScanline[i].y < 8) {
                                // Reading Top half Tile
                                sprite_pattern_addr_lo =
                                        ushort(ushort((spriteScanline[i].id & 0x01) << 12)  // Which Pattern Table? 0KB or 4KB offset
                                                | ushort((spriteScanline[i].id & 0xFE) << 4)  // Which Cell? Tile ID * 16 (16 bytes per tile)
                                                | ushort((scanline - spriteScanline[i].y) & 0x07)); // Which Row in cell? (0->7)
                            }
                            else {
                                // Reading Bottom Half Tile
                                sprite_pattern_addr_lo =
                                        ushort(ushort((spriteScanline[i].id & 0x01) << 12)  // Which Pattern Table? 0KB or 4KB offset
                                                | ushort(((spriteScanline[i].id & 0xFE) + 1) << 4)  // Which Cell? Tile ID * 16 (16 bytes per tile)
                                                | ushort((scanline - spriteScanline[i].y) & 0x07)); // Which Row in cell? (0->7)
                            }
                        }
                        else {
                            if (scanline - spriteScanline[i].y < 8) {
                                // Reading Top half Tile
                                sprite_pattern_addr_lo =
                                        ushort((ushort(spriteScanline[i].id & 0x01) << 12)    // Which Pattern Table? 0KB or 4KB offset
                                                | ushort(((spriteScanline[i].id & 0xFE) + 1) << 4)    // Which Cell? Tile ID * 16 (16 bytes per tile)
                                                | ushort(7 - (scanline - spriteScanline[i].y) & 0x07)); // Which Row in cell? (0->7)
                            }
                            else {
                                // Reading Bottom Half Tile
                                sprite_pattern_addr_lo =
                                        ushort((ushort(spriteScanline[i].id & 0x01) << 12)    // Which Pattern Table? 0KB or 4KB offset
                                                | ushort((spriteScanline[i].id & 0xFE) << 4)    // Which Cell? Tile ID * 16 (16 bytes per tile)
                                                | ushort(7 - (scanline - spriteScanline[i].y) & 0x07)); // Which Row in cell? (0->7)
                            }
                        }
                    }

                    sprite_pattern_addr_hi = ushort(sprite_pattern_addr_lo + 8);

                    sprite_pattern_bits_lo = ppuRead(sprite_pattern_addr_lo);
                    sprite_pattern_bits_hi = ppuRead(sprite_pattern_addr_hi);

                    if ((spriteScanline[i].attribute & 0x40) > 0){
                        sprite_pattern_bits_lo = flipbyte(sprite_pattern_bits_lo);
                        sprite_pattern_bits_hi = flipbyte(sprite_pattern_bits_hi);
                    }
                    sprite_shifter_pattern_lo[i] = sprite_pattern_bits_lo;
                    sprite_shifter_pattern_hi[i] = sprite_pattern_bits_hi;
                }
            }
        }

        if (scanline == 240){
            //Nothing happens
        }

        if (scanline >= 241 && scanline < 261){
            if (this.scanline == 241 && this.cycle == 1){
                this.status.set(REGISTERS.VERTICAL_BLANK, (short) 1);
                if (this.control.get(REGISTERS.ENABLE_NMI) > 0){
                    this.nmi = true;
                }
            }
        }

        short bg_pixel = 0x00;
        short bg_palette = 0x00;

        if (mask.get(REGISTERS.RENDER_BACKGROUND) > 0){
            int bit_mux = 0x8000 >> fine_x;

            // Select Plane pixels by extracting from the shifter
            // at the required location.
            short p0_pixel = ubyte((short) ((bg_shifter_pattern_lo & bit_mux) > 0 ? 1 : 0));
            short p1_pixel = ubyte((short) ((bg_shifter_pattern_hi & bit_mux) > 0 ? 1 : 0));

            // Combine to form pixel index
            bg_pixel = ubyte((short) ((p1_pixel << 1) | p0_pixel));

            // Get palette
            short bg_pal0 = ubyte((short) ((bg_shifter_attrib_lo & bit_mux) > 0 ? 1 : 0));
            short bg_pal1 = ubyte((short) ((bg_shifter_attrib_hi & bit_mux) > 0 ? 1 : 0));
            bg_palette = ubyte((short) ((bg_pal1 << 1) | bg_pal0));
        }

        short fg_pixel = 0x00;   // The 2-bit pixel to be rendered
        short fg_palette = 0x00; // The 3-bit index of the palette the pixel indexes
        short fg_priority = 0x00;// A bit of the sprite attribute indicates if its


        if (mask.get(REGISTERS.RENDER_SPRITES) > 0)
        {
            bSpriteZeroBeingRendered = false;

            for (short i = 0; i < sprite_count; i++)
            {
                if (spriteScanline[i].x == 0)
                {
                    short fg_pixel_lo = (short) ((sprite_shifter_pattern_lo[i] & 0x80) > 0 ? 1 : 0);
                    short fg_pixel_hi = (short) ((sprite_shifter_pattern_hi[i] & 0x80) > 0 ? 1: 0);
                    fg_pixel = ubyte((short) ((fg_pixel_hi << 1) | fg_pixel_lo));

                    fg_palette = ubyte((short) ((spriteScanline[i].attribute & 0x03) + 0x04));
                    fg_priority = (short) ((spriteScanline[i].attribute & 0x20) == 0? 1 : 0);

                    if (fg_pixel != 0) {
                        if (i == 0) {
                            bSpriteZeroBeingRendered = true;
                        }
                        break;
                    }
                }
            }
        }

        short pixel = 0x00;   // The FINAL Pixel...
        short palette = 0x00; // The FINAL Palette...

        if (bg_pixel == 0 && fg_pixel == 0) {
            pixel = 0x00;
            palette = 0x00;
        }
        else if (bg_pixel == 0 && fg_pixel > 0) {
            pixel = fg_pixel;
            palette = fg_palette;
        }
        else if (bg_pixel > 0 && fg_pixel == 0) {
            pixel = bg_pixel;
            palette = bg_palette;
        }
        else if (bg_pixel > 0 && fg_pixel > 0)
        {
            if (fg_priority > 0) {
                pixel = fg_pixel;
                palette = fg_palette;
            }
            else {
                pixel = bg_pixel;
                palette = bg_palette;
            }

            if (bSpriteZeroHitPossible && bSpriteZeroBeingRendered) {
                if ((mask.get(REGISTERS.RENDER_BACKGROUND) & mask.get(REGISTERS.RENDER_SPRITES)) > 0) {
                    if (ushort(~(mask.get(REGISTERS.RENDER_BACKGROUND_LEFT) | mask.get(REGISTERS.RENDER_SPRITES_LEFT))) > 0) {
                        if (cycle >= 9 && cycle < 258) {
                            status.set(REGISTERS.SPRITE_ZERO_HIT, (short) 1);
                        }
                    }
                    else {
                        if (cycle >= 1 && cycle < 258) {
                            status.set(REGISTERS.SPRITE_ZERO_HIT, (short) 1);
                        }
                    }
                }
            }
        }


        this.sprScreen.setPixel(cycle - 1, scanline, this.getColourFromPaletteRam(palette, pixel));

        this.cycle = ushort(this.cycle + 1);
        if (this.cycle >= 341){
            this.cycle = 0;
            this.scanline = ushort(this.scanline + 1);
            if (this.scanline >= 261){
                this.scanline = -1;
                this.frame_complete = true;
            }
        }

    }

    @Override
    public void reset() {
        fine_x = 0x00;
        address_latch = 0x00;
        ppu_data_buffer = 0x00;
        scanline = 0;
        cycle = 0;
        bg_next_tile_id = 0x00;
        bg_next_tile_attrib = 0x00;
        bg_next_tile_lsb = 0x00;
        bg_next_tile_msb = 0x00;
        bg_shifter_pattern_lo = 0x0000;
        bg_shifter_pattern_hi = 0x0000;
        bg_shifter_attrib_lo = 0x0000;
        bg_shifter_attrib_hi = 0x0000;
        status.set(REGISTERS.REG,(short) 0x00);
        mask.set(REGISTERS.REG, (short) 0x00);
        control.set(REGISTERS.REG, (short) 0x00);
        vram_addr.set(REGISTERS.REG, 0x0000);
        tram_addr.set(REGISTERS.REG, 0x0000);

    }
}
