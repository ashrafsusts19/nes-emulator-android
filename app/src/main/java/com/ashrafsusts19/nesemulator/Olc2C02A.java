package com.ashrafsusts19.nesemulator;

public abstract class Olc2C02A {
    public class Status{
        public static enum MEMBER {
            UNUSED,
            SPRITE_OVERFLOW,
            SPRITE_ZERO_HIT,
            VERTICAL_BLANK,
            REG;
        }

        private short reg;
        private short unused, sprite_overflow, sprite_zero_hit, vertical_blank;
        public Status(){
            this.reg = 0x00;
            this.updateAttribute();
        }
        public void set(MEMBER flag, short val){
            val = ubyte(val);
            switch (flag){
                case UNUSED:
                    this.unused = val;
                    break;
                case SPRITE_OVERFLOW:
                    this.sprite_overflow = val;
                    break;
                case SPRITE_ZERO_HIT:
                    this.sprite_zero_hit = val;
                    break;
                case VERTICAL_BLANK:
                    this.vertical_blank = val;
                    break;
                case REG:
                    this.reg = val;
                    break;
            }
            if (flag == MEMBER.REG){
                this.updateAttribute();
            }
            else {
                this.updateRegister();
            }
        }
        public short get(MEMBER flag){
            switch (flag){
                case UNUSED:
                    return this.unused;
                case SPRITE_OVERFLOW:
                    return this.sprite_overflow;
                case SPRITE_ZERO_HIT:
                    return this.sprite_zero_hit;
                case VERTICAL_BLANK:
                    return this.vertical_blank;
                case REG:
                    return this.reg;
            }
            return (short) 0;
        }

        private void updateAttribute(){
            short tmpreg = this.reg;
            this.unused = (short) (tmpreg & 0b11111);
            tmpreg >>= 5;
            this.sprite_overflow = (short) (tmpreg % 2);
            tmpreg >>= 1;
            this.sprite_zero_hit = (short) (tmpreg % 2);
            tmpreg >>= 1;
            this.vertical_blank = (short) (tmpreg % 2);
        }

        private void updateRegister(){
            this.reg = (short) ((this.vertical_blank << 7) | (this.sprite_zero_hit << 6) |
                    (this.sprite_overflow << 5) | (this.unused));
        }
    }

    public class Mask{
        public static enum MEMBER {
            GRAYSCALE,
            RENDER_BACKGROUND_LEFT,
            RENDER_SPRITES_LEFT,
            RENDER_BACKGROUND,
            RENDER_SPRITES,
            ENHANCE_RED,
            ENHANCE_GREEN,
            ENHANCE_BLUE,
            REG;
        }

        private short reg;
        private short grayscale;
        private short render_background_left;
        private short render_sprites_left;
        private short render_background;
        private short render_sprites;
        private short enhance_red;
        private short enhance_green;
        private short enhance_blue;
        public Mask(){
            this.reg = 0x00;
            this.updateAttribute();
        }
        public void set(MEMBER flag, short val){
            val = ubyte(val);
            switch (flag){
                case GRAYSCALE:
                    this.grayscale = val;
                    break;
                case RENDER_BACKGROUND_LEFT:
                    this.render_background_left = val;
                    break;
                case RENDER_SPRITES_LEFT:
                    this.render_sprites_left = val;
                    break;
                case RENDER_BACKGROUND:
                    this.render_background = val;
                    break;
                case RENDER_SPRITES:
                    this.render_sprites = val;
                    break;
                case ENHANCE_RED:
                    this.enhance_red = val;
                    break;
                case ENHANCE_GREEN:
                    this.enhance_green = val;
                    break;
                case ENHANCE_BLUE:
                    this.enhance_blue = val;
                    break;
                case REG:
                    this.reg = val;
                    break;
            }
            if (flag == MEMBER.REG){
                this.updateAttribute();
            }
            else {
                this.updateRegister();
            }
        }
        public short get(MEMBER flag){
            switch (flag){
                case GRAYSCALE:
                    return this.grayscale;
                case RENDER_BACKGROUND_LEFT:
                    return this.render_background_left;
                case RENDER_SPRITES_LEFT:
                    return this.render_sprites_left;
                case RENDER_BACKGROUND:
                    return this.render_background;
                case RENDER_SPRITES:
                    return this.render_sprites;
                case ENHANCE_RED:
                    return this.enhance_red;
                case ENHANCE_GREEN:
                    return this.enhance_green;
                case ENHANCE_BLUE:
                    return this.enhance_blue;
                case REG:
                    return this.reg;
            }
            return (short) 0;
        }

        private void updateAttribute(){
            this.grayscale = (short) ((this.reg & (1 << 0)) > 0? 1: 0);
            this.render_background_left = (short) ((this.reg & (1 << 1)) > 0? 1: 0);
            this.render_sprites_left = (short) ((this.reg & (1 << 2)) > 0? 1: 0);
            this.render_background = (short) ((this.reg & (1 << 3)) > 0? 1: 0);
            this.render_sprites = (short) ((this.reg & (1 << 4)) > 0? 1: 0);
            this.enhance_red = (short) ((this.reg & (1 << 5)) > 0? 1: 0);
            this.enhance_green = (short) ((this.reg & (1 << 6)) > 0? 1: 0);
            this.enhance_blue = (short) ((this.reg & (1 << 7)) > 0? 1: 0);
        }

        private void updateRegister(){
            short tmpReg = 0;
            tmpReg |= this.enhance_blue; tmpReg <<= 1;
            tmpReg |= this.enhance_green; tmpReg <<= 1;
            tmpReg |= this.enhance_red; tmpReg <<= 1;
            tmpReg |= this.render_sprites; tmpReg <<= 1;
            tmpReg |= this.render_background; tmpReg <<= 1;
            tmpReg |= this.render_sprites_left; tmpReg <<= 1;
            tmpReg |= this.render_background_left; tmpReg <<= 1;
            tmpReg |= this.grayscale;
            this.reg = tmpReg;
        }
    }

    public class Control{
        public static enum MEMBER {
            NAMETABLE_X,
            NAMETABLE_Y,
            INCREMENT_MODE,
            PATTERN_SPRITE,
            PATTERN_BACKGROUND,
            SPRITE_SIZE,
            SLAVE_MODE,
            ENABLE_NMI,
            REG;
        }

        private short reg;
        private short nametable_x;
        private short nametable_y;
        private short increment_mode;
        private short pattern_sprite;
        private short pattern_background;
        private short sprite_size;
        private short slave_mode;
        private short enable_nmi;
        public Control(){
            this.reg = 0x00;
            this.updateAttribute();
        }
        public void set(MEMBER flag, short val){
            val = ubyte(val);
            switch (flag){
                case NAMETABLE_X:
                    this.nametable_x = val;
                    break;
                case NAMETABLE_Y:
                    this.nametable_y = val;
                    break;
                case INCREMENT_MODE:
                    this.increment_mode = val;
                    break;
                case PATTERN_SPRITE:
                    this.pattern_sprite = val;
                    break;
                case PATTERN_BACKGROUND:
                    this.pattern_background = val;
                    break;
                case SPRITE_SIZE:
                    this.sprite_size = val;
                    break;
                case SLAVE_MODE:
                    this.slave_mode = val;
                    break;
                case ENABLE_NMI:
                    this.enable_nmi = val;
                    break;
                case REG:
                    this.reg = val;
                    break;
            }
            if (flag == MEMBER.REG){
                this.updateAttribute();
            }
            else {
                this.updateRegister();
            }
        }
        public short get(MEMBER flag){
            switch (flag){
                case NAMETABLE_X:
                    return this.nametable_x;
                case NAMETABLE_Y:
                    return this.nametable_y;
                case INCREMENT_MODE:
                    return this.increment_mode;
                case PATTERN_SPRITE:
                    return this.pattern_sprite;
                case PATTERN_BACKGROUND:
                    return this.pattern_background;
                case SPRITE_SIZE:
                    return this.sprite_size;
                case SLAVE_MODE:
                    return this.slave_mode;
                case ENABLE_NMI:
                    return this.enable_nmi;
                case REG:
                    return this.reg;
            }
            return (short) 0;
        }

        private void updateAttribute(){
            this.nametable_x = (short) ((this.reg & (1 << 0)) > 0 ? 1 : 0);
            this.nametable_y = (short) ((this.reg & (1 << 1)) > 0 ? 1 : 0);
            this.increment_mode = (short) ((this.reg & (1 << 2)) > 0 ? 1 : 0);
            this.pattern_sprite = (short) ((this.reg & (1 << 3)) > 0 ? 1 : 0);
            this.pattern_background = (short) ((this.reg & (1 << 4)) > 0 ? 1 : 0);
            this.sprite_size = (short) ((this.reg & (1 << 5)) > 0 ? 1 : 0);
            this.slave_mode = (short) ((this.reg & (1 << 6)) > 0 ? 1 : 0);
            this.enable_nmi = (short) ((this.reg & (1 << 7)) > 0 ? 1 : 0);
        }

        private void updateRegister(){
            short tmpReg = 0;
            tmpReg |= this.enable_nmi; tmpReg <<= 1;
            tmpReg |= this.slave_mode; tmpReg <<= 1;
            tmpReg |= this.sprite_size; tmpReg <<= 1;
            tmpReg |= this.pattern_background; tmpReg <<= 1;
            tmpReg |= this.pattern_sprite; tmpReg <<= 1;
            tmpReg |= this.increment_mode; tmpReg <<= 1;
            tmpReg |= this.nametable_y; tmpReg <<= 1;
            tmpReg |= this.nametable_x;
            this.reg = tmpReg;
        }
    }

    public class Loopy_register{
        public static enum MEMBER {
            COARSE_X,
            COARSE_Y,
            NAMETABLE_X,
            NAMETABLE_Y,
            FINE_Y,
            UNUSED,
            REG;
        }

        private int reg;
        private int coarse_x;
        private int coarse_y;
        private int nametable_x;
        private int nametable_y;
        private int fine_y;
        private int unused;
        public Loopy_register(){
            this.reg = 0x00;
            this.updateAttribute();
        }
        public void set(MEMBER flag, int val){
            val = ushort(val);
            switch (flag){
                case COARSE_X:
                    this.coarse_x = val;
                    break;
                case COARSE_Y:
                    this.coarse_y = val;
                    break;
                case NAMETABLE_X:
                    this.nametable_x = val;
                    break;
                case NAMETABLE_Y:
                    this.nametable_y = val;
                    break;
                case FINE_Y:
                    this.fine_y = val;
                    break;
                case UNUSED:
                    this.unused = val;
                    break;
                case REG:
                    this.reg = val;
                    break;
            }
            if (flag == MEMBER.REG){
                this.updateAttribute();
            }
            else {
                this.updateRegister();
            }
        }
        public int get(MEMBER flag){
            switch (flag){
                case COARSE_X:
                    return this.coarse_x;
                case COARSE_Y:
                    return this.coarse_y;
                case NAMETABLE_X:
                    return this.nametable_x;
                case NAMETABLE_Y:
                    return this.nametable_y;
                case FINE_Y:
                    return this.fine_y;
                case UNUSED:
                    return this.unused;
                case REG:
                    return this.reg;
            }
            return 0;
        }

        private void updateAttribute(){
            this.coarse_x = ((this.reg % (1 << 5)) >> 0);
            this.coarse_y = ((this.reg % (1 << 10)) >> 5);
            this.nametable_x = ((this.reg % (1 << 11)) >> 10);
            this.nametable_y = ((this.reg % (1 << 12)) >> 11);
            this.fine_y = ((this.reg % (1 << 15)) >> 12);
            this.unused = ((this.reg % (1 << 16)) >> 15);
        }

        private void updateRegister(){
            short tmpreg = 0x0000;
            tmpreg |= this.unused; tmpreg <<= 3;
            tmpreg |= this.fine_y; tmpreg <<= 1;
            tmpreg |= this.nametable_y; tmpreg <<= 1;
            tmpreg |= this.nametable_x; tmpreg <<= 5;
            tmpreg |= this.coarse_y; tmpreg <<= 5;
            tmpreg |= this.coarse_x;
            this.reg = tmpreg;
        }
    }

    public class Pixel{
        public int r, g, b, a = 255;
        public Pixel(int _r, int _g, int _b){
            this.r = _r;
            this.g = _g;
            this.b = _b;
        }
        public Pixel(int _r, int _g, int _b, int _a){
            this.r = _r;
            this.g = _g;
            this.b = _b;
            this.a = _a;
        }
    }

    public class Sprite{
        int width, height;
        Pixel[][] pixels;
        public Sprite(int w, int h){
            this.width = w;
            this.height = h;
            this.pixels = new Pixel[h][w];
            for (int ih = 0; ih < h; ih++){
                for (int iw = 0; iw < w; iw++){
                    pixels[ih][iw] = new Pixel(0, 0, 0);
                }
            }
        }

        public Pixel getPixel(int x, int y){
            if (x >= this.width || x < 0 || y >= this.height || y < 0){
                return new Pixel(0, 0, 0, 0);
            }
            return this.pixels[y][x];
        }
        public void setPixel(int x, int y, Pixel p){
            if (x >= this.width || x < 0 || y >= this.height || y < 0){
                return;
            }
            this.pixels[y][x] = p;
        }


    }

    private int ushort(int a){
        return a & 0xFFFF;
    }
    private short ubyte (short a){
        return (short) (a & 0xFF);
    }

    public class sObjectAttributeEntry{
        short y = 0;			// Y position of sprite
        short id = 0;			// ID of tile from pattern memory
        short attribute = 0;	// Flags define how sprite should be rendered
        short x = 0;
    }

    public abstract short pOAMGet(short index);
    public abstract void pOAMSet(short index, short data);
    public sObjectAttributeEntry[] OAM = new sObjectAttributeEntry[64];

    public short oam_addr = 0x00;

    public sObjectAttributeEntry[] spriteScanline = new sObjectAttributeEntry[8];
    public short sprite_count;
    public short[] sprite_shifter_pattern_lo = new short[8];
    public short[] sprite_shifter_pattern_hi = new short[8];

    boolean bSpriteZeroHitPossible = false;
    boolean bSpriteZeroBeingRendered = false;

    public Cartridge cart;
    public short[][] tblName;
    public short[] tblPalette;
    public short[][] tblPattern;

    public short address_latch = 0x00;
    public short ppu_data_buffer = 0x00;
    //public int ppu_address = 0x0000;

    public short bg_next_tile_id     = 0x00;
    public short bg_next_tile_attrib = 0x00;
    public short bg_next_tile_lsb    = 0x00;
    public short bg_next_tile_msb    = 0x00;
    public int bg_shifter_pattern_lo = 0x0000;
    public int bg_shifter_pattern_hi = 0x0000;
    public int bg_shifter_attrib_lo  = 0x0000;
    public int bg_shifter_attrib_hi  = 0x0000;

    public Pixel[] palScreen;
    public Sprite sprScreen = new Sprite(256, 240);
    public Sprite[] sprNameTable = new Sprite[2];//{ olc::Sprite(256, 240), olc::Sprite(256, 240) };
    public Sprite[] sprPatternTable = new Sprite[2];//{ olc::Sprite(128, 128), olc::Sprite(128, 128) };

    public Status status;
    public Mask mask;
    public Control control;
    public Loopy_register vram_addr, tram_addr;

    short fine_x = 0x00;

    public abstract Sprite getScreen();
    public abstract Sprite getNameTable(short i);
    public abstract Sprite getPatternTable(short i, short palette);
    public abstract Pixel getColourFromPaletteRam(short palette, short pixel);
    public boolean frame_complete = false;
    public boolean nmi = false;
    public boolean scanline_trigger = false;
    public int scanline = 0, cycle = 0;
    public boolean odd_frame = false;


    public abstract short cpuRead(int addr, boolean readonly);
    public abstract short cpuRead(int addr);
    public abstract void cpuWrite(int addr, short data);

    public abstract short ppuRead(int addr, boolean readonly);
    public abstract short ppuRead(int addr);
    public abstract void ppuWrite(int addr, short data);

    public abstract void ConnectCartridge(Cartridge cartridge);
    public abstract void clock();
    public abstract void reset();
}
