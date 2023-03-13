package com.ashrafsusts19.nesemulator;

import java.lang.reflect.Method;
import java.util.ArrayList;

public abstract class Olc6502A {

    public enum FLAGS6502{
        C((short) (1 << 0)),  // Carry Bit
        Z((short) (1 << 1)),  // Zero
        I((short) (1 << 2)),  // Disable Interrupts
        D((short) (1 << 3)),  // Decimal Mode
        B((short) (1 << 4)),  // Break
        U((short) (1 << 5)),  // Unused
        V((short) (1 << 6)),  // Overflow
        N((short) (1 << 7));  // Negative
        public final short bitNo;
        FLAGS6502(short _bitNo){
            this.bitNo = _bitNo;
        }
    }

    public class INSTRUCTION {
        public String name;
        public Method operate;
        public Method addrMode;
        public short cycles;
        INSTRUCTION(String _name, Method _operate, Method _addrMode, short _cycles){
            this.name = _name;
            this.operate = _operate;
            this.addrMode = _addrMode;
            this.cycles = _cycles;
        }
    }

    public ArrayList<INSTRUCTION> lookupTable;
//    public HashMap<Integer, String> disassemble(int nStart, int nStop);

    public short status = 0x00; // Status register
    public short a = 0x00;      // Accumulator register
    public short x = 0x00;      // X register
    public short y = 0x00;      // Y register
    public short stkp = 0x00;   // Stack pointer (Points to location on Bus)
    public int pc = 0x00;    // Program counter

    public abstract boolean complete();
    public abstract void clock();   // Perform one clocke cycle's worth of update
    public abstract void reset();   // Reset interrupt, force cpu into known state
    public abstract void irq();     // Interrupt Request, executes an instruction at a specific location
    public abstract void nmi();     // Non maskable interrupt request, as above, can't be disabled

    public void connectBus(Bus b){
        this.bus = b;
    }
    // Internal helper functions to facilitate the emulation

    public abstract short getFlag(FLAGS6502 f);
    public abstract void setFlag(FLAGS6502 f, boolean v);

    public abstract short fetch();    // Fetch data from appropriate source
    public short fetched = 0x00;      // Store fetched value
    public int addr_abs = 0x0000;   // Store absolute address
    public int addr_rel = 0x00;     // Relative location from the location where the instruction is called
    public short opcode = 0x00;       // Opcode currently working with
    public short cycles = 0;          // Variable to store the number of cycles left for the current instruction
    public long clock_count = 0;

    public Bus bus;

    public abstract void write(int addr, short data);
    public abstract short read(int addr);

    // Addressing Modes
    public abstract int IMP();	public abstract int IMM();
    public abstract int ZP0();	public abstract int ZPX();
    public abstract int ZPY();	public abstract int REL();
    public abstract int ABS();	public abstract int ABX();
    public abstract int ABY();	public abstract int IND();
    public abstract int IZX();	public abstract int IZY();

    public abstract int ADC();	public abstract int AND();	public abstract int ASL();	public abstract int BCC();
    public abstract int BCS();	public abstract int BEQ();	public abstract int BIT();	public abstract int BMI();
    public abstract int BNE();	public abstract int BPL();	public abstract int BRK();	public abstract int BVC();
    public abstract int BVS();	public abstract int CLC();	public abstract int CLD();	public abstract int CLI();
    public abstract int CLV();	public abstract int CMP();	public abstract int CPX();	public abstract int CPY();
    public abstract int DEC();	public abstract int DEX();	public abstract int DEY();	public abstract int EOR();
    public abstract int INC();	public abstract int INX();	public abstract int INY();	public abstract int JMP();
    public abstract int JSR();	public abstract int LDA();	public abstract int LDX();	public abstract int LDY();
    public abstract int LSR();	public abstract int NOP();	public abstract int ORA();	public abstract int PHA();
    public abstract int PHP();	public abstract int PLA();	public abstract int PLP();	public abstract int ROL();
    public abstract int ROR();	public abstract int RTI();	public abstract int RTS();	public abstract int SBC();
    public abstract int SEC();	public abstract int SED();	public abstract int SEI();	public abstract int STA();
    public abstract int STX();	public abstract int STY();	public abstract int TAX();	public abstract int TAY();
    public abstract int TSX();	public abstract int TXA();	public abstract int TXS();	public abstract int TYA();

    public abstract int XXX();

}
