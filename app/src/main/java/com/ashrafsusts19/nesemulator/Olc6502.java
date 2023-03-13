package com.ashrafsusts19.nesemulator;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Olc6502 extends Olc6502A {

    public Olc6502(){
        lookupTable = new ArrayList<>();
        this.getLookup("BRK", "BRK", "IMM", (short) 7);this.getLookup("ORA", "ORA", "IZX", (short) 6);this.getLookup("???", "XXX", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 8);this.getLookup("???", "NOP", "IMP", (short) 3);this.getLookup("ORA", "ORA", "ZP0", (short) 3);this.getLookup("ASL", "ASL", "ZP0", (short) 5);this.getLookup("???", "XXX", "IMP", (short) 5);this.getLookup("PHP", "PHP", "IMP", (short) 3);this.getLookup("ORA", "ORA", "IMM", (short) 2);this.getLookup("ASL", "ASL", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 2);this.getLookup("???", "NOP", "IMP", (short) 4);this.getLookup("ORA", "ORA", "ABS", (short) 4);this.getLookup("ASL", "ASL", "ABS", (short) 6);this.getLookup("???", "XXX", "IMP", (short) 6);
        this.getLookup("BPL", "BPL", "REL", (short) 2);this.getLookup("ORA", "ORA", "IZY", (short) 5);this.getLookup("???", "XXX", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 8);this.getLookup("???", "NOP", "IMP", (short) 4);this.getLookup("ORA", "ORA", "ZPX", (short) 4);this.getLookup("ASL", "ASL", "ZPX", (short) 6);this.getLookup("???", "XXX", "IMP", (short) 6);this.getLookup("CLC", "CLC", "IMP", (short) 2);this.getLookup("ORA", "ORA", "ABY", (short) 4);this.getLookup("???", "NOP", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 7);this.getLookup("???", "NOP", "IMP", (short) 4);this.getLookup("ORA", "ORA", "ABX", (short) 4);this.getLookup("ASL", "ASL", "ABX", (short) 7);this.getLookup("???", "XXX", "IMP", (short) 7);
        this.getLookup("JSR", "JSR", "ABS", (short) 6);this.getLookup("AND", "AND", "IZX", (short) 6);this.getLookup("???", "XXX", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 8);this.getLookup("BIT", "BIT", "ZP0", (short) 3);this.getLookup("AND", "AND", "ZP0", (short) 3);this.getLookup("ROL", "ROL", "ZP0", (short) 5);this.getLookup("???", "XXX", "IMP", (short) 5);this.getLookup("PLP", "PLP", "IMP", (short) 4);this.getLookup("AND", "AND", "IMM", (short) 2);this.getLookup("ROL", "ROL", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 2);this.getLookup("BIT", "BIT", "ABS", (short) 4);this.getLookup("AND", "AND", "ABS", (short) 4);this.getLookup("ROL", "ROL", "ABS", (short) 6);this.getLookup("???", "XXX", "IMP", (short) 6);
        this.getLookup("BMI", "BMI", "REL", (short) 2);this.getLookup("AND", "AND", "IZY", (short) 5);this.getLookup("???", "XXX", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 8);this.getLookup("???", "NOP", "IMP", (short) 4);this.getLookup("AND", "AND", "ZPX", (short) 4);this.getLookup("ROL", "ROL", "ZPX", (short) 6);this.getLookup("???", "XXX", "IMP", (short) 6);this.getLookup("SEC", "SEC", "IMP", (short) 2);this.getLookup("AND", "AND", "ABY", (short) 4);this.getLookup("???", "NOP", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 7);this.getLookup("???", "NOP", "IMP", (short) 4);this.getLookup("AND", "AND", "ABX", (short) 4);this.getLookup("ROL", "ROL", "ABX", (short) 7);this.getLookup("???", "XXX", "IMP", (short) 7);
        this.getLookup("RTI", "RTI", "IMP", (short) 6);this.getLookup("EOR", "EOR", "IZX", (short) 6);this.getLookup("???", "XXX", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 8);this.getLookup("???", "NOP", "IMP", (short) 3);this.getLookup("EOR", "EOR", "ZP0", (short) 3);this.getLookup("LSR", "LSR", "ZP0", (short) 5);this.getLookup("???", "XXX", "IMP", (short) 5);this.getLookup("PHA", "PHA", "IMP", (short) 3);this.getLookup("EOR", "EOR", "IMM", (short) 2);this.getLookup("LSR", "LSR", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 2);this.getLookup("JMP", "JMP", "ABS", (short) 3);this.getLookup("EOR", "EOR", "ABS", (short) 4);this.getLookup("LSR", "LSR", "ABS", (short) 6);this.getLookup("???", "XXX", "IMP", (short) 6);
        this.getLookup("BVC", "BVC", "REL", (short) 2);this.getLookup("EOR", "EOR", "IZY", (short) 5);this.getLookup("???", "XXX", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 8);this.getLookup("???", "NOP", "IMP", (short) 4);this.getLookup("EOR", "EOR", "ZPX", (short) 4);this.getLookup("LSR", "LSR", "ZPX", (short) 6);this.getLookup("???", "XXX", "IMP", (short) 6);this.getLookup("CLI", "CLI", "IMP", (short) 2);this.getLookup("EOR", "EOR", "ABY", (short) 4);this.getLookup("???", "NOP", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 7);this.getLookup("???", "NOP", "IMP", (short) 4);this.getLookup("EOR", "EOR", "ABX", (short) 4);this.getLookup("LSR", "LSR", "ABX", (short) 7);this.getLookup("???", "XXX", "IMP", (short) 7);
        this.getLookup("RTS", "RTS", "IMP", (short) 6);this.getLookup("ADC", "ADC", "IZX", (short) 6);this.getLookup("???", "XXX", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 8);this.getLookup("???", "NOP", "IMP", (short) 3);this.getLookup("ADC", "ADC", "ZP0", (short) 3);this.getLookup("ROR", "ROR", "ZP0", (short) 5);this.getLookup("???", "XXX", "IMP", (short) 5);this.getLookup("PLA", "PLA", "IMP", (short) 4);this.getLookup("ADC", "ADC", "IMM", (short) 2);this.getLookup("ROR", "ROR", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 2);this.getLookup("JMP", "JMP", "IND", (short) 5);this.getLookup("ADC", "ADC", "ABS", (short) 4);this.getLookup("ROR", "ROR", "ABS", (short) 6);this.getLookup("???", "XXX", "IMP", (short) 6);
        this.getLookup("BVS", "BVS", "REL", (short) 2);this.getLookup("ADC", "ADC", "IZY", (short) 5);this.getLookup("???", "XXX", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 8);this.getLookup("???", "NOP", "IMP", (short) 4);this.getLookup("ADC", "ADC", "ZPX", (short) 4);this.getLookup("ROR", "ROR", "ZPX", (short) 6);this.getLookup("???", "XXX", "IMP", (short) 6);this.getLookup("SEI", "SEI", "IMP", (short) 2);this.getLookup("ADC", "ADC", "ABY", (short) 4);this.getLookup("???", "NOP", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 7);this.getLookup("???", "NOP", "IMP", (short) 4);this.getLookup("ADC", "ADC", "ABX", (short) 4);this.getLookup("ROR", "ROR", "ABX", (short) 7);this.getLookup("???", "XXX", "IMP", (short) 7);
        this.getLookup("???", "NOP", "IMP", (short) 2);this.getLookup("STA", "STA", "IZX", (short) 6);this.getLookup("???", "NOP", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 6);this.getLookup("STY", "STY", "ZP0", (short) 3);this.getLookup("STA", "STA", "ZP0", (short) 3);this.getLookup("STX", "STX", "ZP0", (short) 3);this.getLookup("???", "XXX", "IMP", (short) 3);this.getLookup("DEY", "DEY", "IMP", (short) 2);this.getLookup("???", "NOP", "IMP", (short) 2);this.getLookup("TXA", "TXA", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 2);this.getLookup("STY", "STY", "ABS", (short) 4);this.getLookup("STA", "STA", "ABS", (short) 4);this.getLookup("STX", "STX", "ABS", (short) 4);this.getLookup("???", "XXX", "IMP", (short) 4);
        this.getLookup("BCC", "BCC", "REL", (short) 2);this.getLookup("STA", "STA", "IZY", (short) 6);this.getLookup("???", "XXX", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 6);this.getLookup("STY", "STY", "ZPX", (short) 4);this.getLookup("STA", "STA", "ZPX", (short) 4);this.getLookup("STX", "STX", "ZPY", (short) 4);this.getLookup("???", "XXX", "IMP", (short) 4);this.getLookup("TYA", "TYA", "IMP", (short) 2);this.getLookup("STA", "STA", "ABY", (short) 5);this.getLookup("TXS", "TXS", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 5);this.getLookup("???", "NOP", "IMP", (short) 5);this.getLookup("STA", "STA", "ABX", (short) 5);this.getLookup("???", "XXX", "IMP", (short) 5);this.getLookup("???", "XXX", "IMP", (short) 5);
        this.getLookup("LDY", "LDY", "IMM", (short) 2);this.getLookup("LDA", "LDA", "IZX", (short) 6);this.getLookup("LDX", "LDX", "IMM", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 6);this.getLookup("LDY", "LDY", "ZP0", (short) 3);this.getLookup("LDA", "LDA", "ZP0", (short) 3);this.getLookup("LDX", "LDX", "ZP0", (short) 3);this.getLookup("???", "XXX", "IMP", (short) 3);this.getLookup("TAY", "TAY", "IMP", (short) 2);this.getLookup("LDA", "LDA", "IMM", (short) 2);this.getLookup("TAX", "TAX", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 2);this.getLookup("LDY", "LDY", "ABS", (short) 4);this.getLookup("LDA", "LDA", "ABS", (short) 4);this.getLookup("LDX", "LDX", "ABS", (short) 4);this.getLookup("???", "XXX", "IMP", (short) 4);
        this.getLookup("BCS", "BCS", "REL", (short) 2);this.getLookup("LDA", "LDA", "IZY", (short) 5);this.getLookup("???", "XXX", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 5);this.getLookup("LDY", "LDY", "ZPX", (short) 4);this.getLookup("LDA", "LDA", "ZPX", (short) 4);this.getLookup("LDX", "LDX", "ZPY", (short) 4);this.getLookup("???", "XXX", "IMP", (short) 4);this.getLookup("CLV", "CLV", "IMP", (short) 2);this.getLookup("LDA", "LDA", "ABY", (short) 4);this.getLookup("TSX", "TSX", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 4);this.getLookup("LDY", "LDY", "ABX", (short) 4);this.getLookup("LDA", "LDA", "ABX", (short) 4);this.getLookup("LDX", "LDX", "ABY", (short) 4);this.getLookup("???", "XXX", "IMP", (short) 4);
        this.getLookup("CPY", "CPY", "IMM", (short) 2);this.getLookup("CMP", "CMP", "IZX", (short) 6);this.getLookup("???", "NOP", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 8);this.getLookup("CPY", "CPY", "ZP0", (short) 3);this.getLookup("CMP", "CMP", "ZP0", (short) 3);this.getLookup("DEC", "DEC", "ZP0", (short) 5);this.getLookup("???", "XXX", "IMP", (short) 5);this.getLookup("INY", "INY", "IMP", (short) 2);this.getLookup("CMP", "CMP", "IMM", (short) 2);this.getLookup("DEX", "DEX", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 2);this.getLookup("CPY", "CPY", "ABS", (short) 4);this.getLookup("CMP", "CMP", "ABS", (short) 4);this.getLookup("DEC", "DEC", "ABS", (short) 6);this.getLookup("???", "XXX", "IMP", (short) 6);
        this.getLookup("BNE", "BNE", "REL", (short) 2);this.getLookup("CMP", "CMP", "IZY", (short) 5);this.getLookup("???", "XXX", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 8);this.getLookup("???", "NOP", "IMP", (short) 4);this.getLookup("CMP", "CMP", "ZPX", (short) 4);this.getLookup("DEC", "DEC", "ZPX", (short) 6);this.getLookup("???", "XXX", "IMP", (short) 6);this.getLookup("CLD", "CLD", "IMP", (short) 2);this.getLookup("CMP", "CMP", "ABY", (short) 4);this.getLookup("NOP", "NOP", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 7);this.getLookup("???", "NOP", "IMP", (short) 4);this.getLookup("CMP", "CMP", "ABX", (short) 4);this.getLookup("DEC", "DEC", "ABX", (short) 7);this.getLookup("???", "XXX", "IMP", (short) 7);
        this.getLookup("CPX", "CPX", "IMM", (short) 2);this.getLookup("SBC", "SBC", "IZX", (short) 6);this.getLookup("???", "NOP", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 8);this.getLookup("CPX", "CPX", "ZP0", (short) 3);this.getLookup("SBC", "SBC", "ZP0", (short) 3);this.getLookup("INC", "INC", "ZP0", (short) 5);this.getLookup("???", "XXX", "IMP", (short) 5);this.getLookup("INX", "INX", "IMP", (short) 2);this.getLookup("SBC", "SBC", "IMM", (short) 2);this.getLookup("NOP", "NOP", "IMP", (short) 2);this.getLookup("???", "SBC", "IMP", (short) 2);this.getLookup("CPX", "CPX", "ABS", (short) 4);this.getLookup("SBC", "SBC", "ABS", (short) 4);this.getLookup("INC", "INC", "ABS", (short) 6);this.getLookup("???", "XXX", "IMP", (short) 6);
        this.getLookup("BEQ", "BEQ", "REL", (short) 2);this.getLookup("SBC", "SBC", "IZY", (short) 5);this.getLookup("???", "XXX", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 8);this.getLookup("???", "NOP", "IMP", (short) 4);this.getLookup("SBC", "SBC", "ZPX", (short) 4);this.getLookup("INC", "INC", "ZPX", (short) 6);this.getLookup("???", "XXX", "IMP", (short) 6);this.getLookup("SED", "SED", "IMP", (short) 2);this.getLookup("SBC", "SBC", "ABY", (short) 4);this.getLookup("NOP", "NOP", "IMP", (short) 2);this.getLookup("???", "XXX", "IMP", (short) 7);this.getLookup("???", "NOP", "IMP", (short) 4);this.getLookup("SBC", "SBC", "ABX", (short) 4);this.getLookup("INC", "INC", "ABX", (short) 7);this.getLookup("???", "XXX", "IMP", (short) 7);
    }

    private void getLookup(String _name, String _operate, String _addrMode, short _cycles){

        try {
            lookupTable.add(new Olc6502A.INSTRUCTION(_name, Olc6502.class.getMethod(_operate), Olc6502.class.getMethod(_addrMode), _cycles));
        } catch (NoSuchMethodException e) {
            System.out.println("Can't Find Method");
            e.printStackTrace();
        }
    }

    private int ushort(int a){
        return a & 0xFFFF;
    }
    private short ubyte (short a){
        return (short) (a & 0xFF);
    }

    @Override
    public void clock() {
        if (this.cycles == 0){
            this.opcode = ubyte(read(this.pc));
            this.setFlag(Olc6502A.FLAGS6502.U, true);
            this.pc = ushort(this.pc + 1);
            Olc6502A.INSTRUCTION instruction = lookupTable.get(opcode);
//            System.out.println(opcode + " " + instruction.addrMode.getName() + " " + instruction.operate.getName());
//            System.out.println(String.format("%x", this.pc));
            this.cycles = instruction.cycles;
            short additional_cycle1 = 0, additional_cycle2 = 0;

            try {
                Integer ac1 = (Integer) instruction.addrMode.invoke(this);
                additional_cycle1 = ac1.shortValue();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            try {
                Integer ac2 = (Integer) instruction.operate.invoke(this);
                additional_cycle2 = ac2.shortValue();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            this.cycles += additional_cycle1 & additional_cycle2;
            this.setFlag(Olc6502A.FLAGS6502.U, true);
        }
        this.clock_count++;
        this.cycles = ubyte((short) (this.cycles - 1));
    }

    public boolean complete()
    {
        return this.cycles == 0;
    }

    public short getFlag(Olc6502A.FLAGS6502 f){
        return (short) ((this.status & f.bitNo) > 0 ? 1: 0);
    }

    public void setFlag(Olc6502A.FLAGS6502 f, boolean v){
        if (v){
            this.status |= f.bitNo;
        }
        else {
            this.status &= (~f.bitNo);
        }
    }

    @Override
    public void reset() {
        this.addr_abs = 0xFFFC;
        int lo = ushort(read(this.addr_abs + 0));
        int hi = ushort(read(this.addr_abs + 1));

        this.pc = ushort((hi << 8) | lo);

        this.a = 0;
        this.x = 0;
        this.y = 0;
        this.stkp = 0xFD;
        this.status = 0x00;
        setFlag(Olc6502A.FLAGS6502.U, true);

        this.addr_abs = 0x0000;
        this.addr_rel = 0x0000;
        this.fetched = 0x00;

        this.cycles = 8;
    }

    @Override
    public void irq() {
        if (getFlag(Olc6502A.FLAGS6502.I) == 0){
            write(0x0100 + this.stkp, (short) ((this.pc >> 8) & 0x00FF));
            this.stkp = ubyte(--this.stkp);
            write(0x0100 + this.stkp, (short) (this.pc & 0x00FF));
            this.stkp = ubyte(--this.stkp);

            setFlag(Olc6502A.FLAGS6502.B, false);
            setFlag(Olc6502A.FLAGS6502.U, true);
            setFlag(Olc6502A.FLAGS6502.I, true);
            write(0x0100 + this.stkp, status);
            this.stkp = ubyte(--this.stkp);

            this.addr_abs = 0xFFFE;
            int lo = read(this.addr_abs + 0);
            int hi = read(this.addr_abs + 1);
            this.pc = ushort((hi << 8) | lo);

            this.cycles = 7;
        }
    }

    @Override
    public void nmi() {
        write(0x0100 + this.stkp, (short) ((this.pc >> 8) & 0x00FF));
        this.stkp = ubyte(--this.stkp);
        write(0x0100 + this.stkp, (short) (this.pc & 0x00FF));
        this.stkp = ubyte(--this.stkp);

        setFlag(Olc6502A.FLAGS6502.B, false);
        setFlag(Olc6502A.FLAGS6502.U, true);
        setFlag(Olc6502A.FLAGS6502.I, true);
        write(0x0100 + this.stkp, status);
        this.stkp = ubyte(--this.stkp);

        this.addr_abs = 0xFFFA;
        int lo = ushort(read(this.addr_abs + 0));
        int hi = ushort(read(this.addr_abs + 1));
        this.pc = ushort((hi << 8) | lo);

        this.cycles = 8;
    }

    @Override
    public short fetch() {
        if (!(lookupTable.get(opcode).addrMode.getName() == "IMP"))
            this.fetched = ubyte(read(this.addr_abs));
        return this.fetched;
    }

    @Override
    public void write(int addr, short data) {
        addr = ushort(addr);
        data = ubyte(data);
        bus.cpuWrite(addr, data);
    }

    @Override
    public short read(int addr) {
        addr = ushort(addr);
        return ubyte(bus.cpuRead(addr, false));
    }



    @Override
    public int IMP() {
        this.fetched = this.a;
        return 0;
    }

    @Override
    public int IMM() {
        this.addr_abs = this.pc;
        this.pc = ushort(this.pc + 1);
        return 0;
    }

    @Override
    public int ZP0() {
        this.addr_abs = ushort(read(this.pc));
        this.pc = ushort(this.pc + 1);
        this.addr_abs &= 0x00FF;
        return 0;
    }

    @Override
    public int ZPX() {
        this.addr_abs = ushort(read(this.pc) + this.x);
        this.pc = ushort(this.pc + 1);
        this.addr_abs &= 0x00FF;
        return 0;
    }

    @Override
    public int ZPY() {
        this.addr_abs = ushort(read(this.pc) + this.y);
        this.pc = ushort(this.pc + 1);
        this.addr_abs &= 0x00FF;
        return 0;
    }

    @Override
    public int REL() {
        this.addr_rel = ushort(read(this.pc));
        this.pc = ushort(this.pc + 1);
        if ((this.addr_rel & 0x80) > 0){
            this.addr_rel |= 0xFF00;
        }
        return 0;
    }

    @Override
    public int ABS() {
        int lo = read(this.pc);
        this.pc = ushort(this.pc + 1);
        int hi = read(this.pc);
        this.pc = ushort(this.pc + 1);
        this.addr_abs = ushort((hi << 8) | lo);
        return 0;
    }

    @Override
    public int ABX() {
        int lo = read(this.pc);
        this.pc = ushort(this.pc + 1);
        int hi = read(this.pc);
        this.pc = ushort(this.pc + 1);

        this.addr_abs = ushort((hi << 8) | lo);
        this.addr_abs = ushort(this.addr_abs + this.x);
        if ((this.addr_abs & 0xFF00) != (hi << 8)){
            return 1;
        }
        else {
            return 0;
        }
    }

    @Override
    public int ABY() {
        int lo = read(this.pc);
        this.pc = ushort(this.pc + 1);
        int hi = read(this.pc);
        this.pc = ushort(this.pc + 1);
        this.addr_abs = ushort((hi << 8) | lo);
        this.addr_abs = ushort(this.addr_abs + this.y);
        if ((this.addr_abs & 0xFF00) != (hi << 8)){
            return 1;
        }
        else {
            return 0;
        }
    }

    @Override
    public int IND() {
        int ptr_lo = read(this.pc);
        this.pc = ushort(this.pc + 1);
        int ptr_hi = read(this.pc);
        this.pc = ushort(this.pc + 1);
        int ptr = (ptr_hi << 8) | ptr_lo;
        if (ptr_lo == 0x00FF){
            this.addr_abs = ushort((read(ptr & 0xFF00) << 8) | read(ptr + 0));
        }
        else {
            this.addr_abs = ushort((read(ptr + 1) << 8) | (read(ptr + 0)));
        }
        return 0;
    }

    @Override
    public int IZX() {
        int t = read(this.pc);
        this.pc = ushort(this.pc + 1);
        int lo = read(ushort((t + ushort(this.x))) & 0x00FF);
        int hi = read(ushort((t + ushort(this.x) + 1)) & 0x00FF);
        this.addr_abs = ushort((hi << 8) | lo);
        return 0;
    }

    @Override
    public int IZY() {
        int t = read(this.pc);
        this.pc = ushort(this.pc + 1);

        int lo = read(t & 0x00FF);
        int hi = read((t + 1) & 0x00FF);

        this.addr_abs = ushort((hi << 8) | lo);
        this.addr_abs = ushort(this.addr_abs + this.y);

        if ((this.addr_abs & 0xFF00) != (hi << 8)){
            return 1;
        }
        else {
            return 0;
        }
    }

    @Override
    public int ADC() {
        fetch();
        int temp = ushort(ushort(this.a) + ushort(this.fetched) + ushort(getFlag(Olc6502A.FLAGS6502.C)));
        setFlag(Olc6502A.FLAGS6502.C, temp > 255);
        setFlag(Olc6502A.FLAGS6502.Z, (temp & 0x00FF) == 0);
        setFlag(Olc6502A.FLAGS6502.N, (temp & 0x80) > 0);
        setFlag(Olc6502A.FLAGS6502.V, ((~(ushort(this.a) ^ ushort(this.fetched)) & (ushort(this.a) ^ ushort(temp))) & 0x0080) > 0);
//        SetFlag(V, (~((uint16_t)a ^ (uint16_t)fetched) & ((uint16_t)a ^ (uint16_t)temp)) & 0x0080);
        this.a = ubyte((short) (temp & 0x00FF));
        return 1;
    }

    @Override
    public int AND() {
        this.fetch();
        this.a = ubyte((short) (this.a & this.fetched));
        this.setFlag(Olc6502A.FLAGS6502.Z, a == 0x00);
        this.setFlag(Olc6502A.FLAGS6502.N, (a & 0x80) > 0);
        return 1;
    }

    @Override
    public int ASL() {
        this.fetch();
        int temp = ushort(fetched << 1);
        setFlag(Olc6502A.FLAGS6502.C, (temp & 0xFF00) > 0);
        setFlag(Olc6502A.FLAGS6502.Z, (temp & 0x00FF) == 0x00);
        setFlag(Olc6502A.FLAGS6502.N, (temp & 0x80) > 0);
//        if (lookup[opcode].addrmode == &olc6502::IMP)
        if (lookupTable.get(this.opcode).addrMode.getName() == "IMP")
            this.a = ubyte((short) (temp & 0x00FF));
        else
            write(addr_abs, (short) (temp & 0x00FF));
        return 0;
    }

    @Override
    public int BCC() {
        if (getFlag(Olc6502A.FLAGS6502.C) == 0) {
            this.cycles = ubyte((short) (this.cycles + 1));
            this.addr_abs = ushort(this.pc + this.addr_rel);
            if ((this.addr_abs & 0xFF00) != (this.pc & 0xFF00)) {
                this.cycles = ubyte((short) (this.cycles + 1));
            }
            this.pc = this.addr_abs;
        }
        return 0;
    }

    @Override
    public int BCS() {
        if (getFlag(Olc6502A.FLAGS6502.C) == 1){
            this.cycles = ubyte((short) (this.cycles + 1));
            this.addr_abs = ushort(this.pc + this.addr_rel);
            if ((this.addr_abs & 0xFF00) != (this.pc & 0xFF00)){
                this.cycles = ubyte((short) (this.cycles + 1));
            }
            this.pc = this.addr_abs;
        }
        return 0;
    }

    @Override
    public int BEQ() {
        if (getFlag(Olc6502A.FLAGS6502.Z) == 1) {
            this.cycles = ubyte((short) (this.cycles + 1));
            this.addr_abs = ushort(this.pc + this.addr_rel);
            if ((this.addr_abs & 0xFF00) != (this.pc & 0xFF00)) {
                this.cycles = ubyte((short) (this.cycles + 1));
            }
            this.pc = this.addr_abs;
        }
        return 0;
    }

    @Override
    public int BIT() {
        this.fetch();
        int temp = ushort(a & fetched);
        setFlag(Olc6502A.FLAGS6502.Z, (temp & 0x00FF) == 0x00);
        setFlag(Olc6502A.FLAGS6502.N, (fetched & (1 << 7)) > 0);
        setFlag(Olc6502A.FLAGS6502.V, (fetched & (1 << 6)) > 0);
        return 0;
    }

    @Override
    public int BMI() {
        if (getFlag(Olc6502A.FLAGS6502.N) == 1) {
            this.cycles = ubyte((short) (this.cycles + 1));
            this.addr_abs = ushort(this.pc + this.addr_rel);
            if ((this.addr_abs & 0xFF00) != (this.pc & 0xFF00)) {
                this.cycles = ubyte((short) (this.cycles + 1));
            }
            this.pc = this.addr_abs;
        }
        return 0;
    }

    @Override
    public int BNE() {
        if (getFlag(Olc6502A.FLAGS6502.Z) == 0) {
            this.cycles = ubyte((short) (this.cycles + 1));
            this.addr_abs = ushort(this.pc + this.addr_rel);
            if ((this.addr_abs & 0xFF00) != (this.pc & 0xFF00)) {
                this.cycles = ubyte((short) (this.cycles + 1));
            }
            this.pc = this.addr_abs;
        }
        return 0;
    }

    @Override
    public int BPL() {
        if (getFlag(Olc6502A.FLAGS6502.N) == 0) {
            this.cycles = ubyte((short) (this.cycles + 1));
            this.addr_abs = ushort(this.pc + this.addr_rel);
            if ((this.addr_abs & 0xFF00) != (this.pc & 0xFF00)) {
                this.cycles = ubyte((short) (this.cycles + 1));
            }
            this.pc = this.addr_abs;
        }
        return 0;
    }

    @Override
    public int BRK() {
        this.pc = ushort(this.pc + 1);

        setFlag(Olc6502A.FLAGS6502.I, true);
        write(0x0100 + stkp, (short) ((pc >> 8) & 0x00FF));
        this.stkp = ubyte((short) (this.stkp - 1));
        write(0x0100 + stkp, (short) (pc & 0x00FF));
        this.stkp = ubyte((short) (this.stkp - 1));

        setFlag(Olc6502A.FLAGS6502.B, true);
        write(0x0100 + stkp, (short) this.status);
        this.stkp = ubyte((short) (this.stkp - 1));
        setFlag(Olc6502A.FLAGS6502.B, false);

        this.pc = ushort(ushort(read(0xFFFE)) | (ushort(read(0xFFFF) << 8)));
        return 0;
    }

    @Override
    public int BVC() {
        if (getFlag(Olc6502A.FLAGS6502.V) == 0) {
            this.cycles = ubyte((short) (this.cycles + 1));
            this.addr_abs = ushort(this.pc + this.addr_rel);
            if ((this.addr_abs & 0xFF00) != (this.pc & 0xFF00)) {
                this.cycles = ubyte((short) (this.cycles + 1));
            }
            this.pc = this.addr_abs;
        }
        return 0;
    }

    @Override
    public int BVS() {
        if (getFlag(Olc6502A.FLAGS6502.V) == 1) {
            this.cycles = ubyte((short) (this.cycles + 1));
            this.addr_abs = ushort(this.pc + this.addr_rel);
            if ((this.addr_abs & 0xFF00) != (this.pc & 0xFF00)) {
                this.cycles = ubyte((short) (this.cycles + 1));
            }
            this.pc = this.addr_abs;
        }
        return 0;
    }

    @Override
    public int CLC() {
        setFlag(Olc6502A.FLAGS6502.C, false);
        return 0;
    }

    @Override
    public int CLD() {
        setFlag(Olc6502A.FLAGS6502.D, false);
        return 0;
    }

    @Override
    public int CLI() {
        setFlag(Olc6502A.FLAGS6502.I, false);
        return 0;
    }

    @Override
    public int CLV() {
        setFlag(Olc6502A.FLAGS6502.V, false);
        return 0;
    }

    @Override
    public int CMP() {
        this.fetch();
        int temp = ushort(ushort(this.a) - ushort(this.fetched));
        setFlag(Olc6502A.FLAGS6502.C, a >= this.fetched);
        setFlag(Olc6502A.FLAGS6502.Z, (temp & 0x00FF) == 0x0000);
        setFlag(Olc6502A.FLAGS6502.N, (temp & 0x0080) > 0);
        return 1;
    }

    @Override
    public int CPX() {
        this.fetch();
        int temp = ushort(ushort(this.x) - ushort(this.fetched));
        setFlag(Olc6502A.FLAGS6502.C, x >= this.fetched);
        setFlag(Olc6502A.FLAGS6502.Z, (temp & 0x00FF) == 0x0000);
        setFlag(Olc6502A.FLAGS6502.N, (temp & 0x0080) > 0);
        return 0;
    }

    @Override
    public int CPY() {
        this.fetch();
        int temp = ushort(ushort(this.y) - ushort(this.fetched));
        setFlag(Olc6502A.FLAGS6502.C, this.y >= fetched);
        setFlag(Olc6502A.FLAGS6502.Z, (temp & 0x00FF) == 0x0000);
        setFlag(Olc6502A.FLAGS6502.N, (temp & 0x0080) > 0);
        return 0;
    }

    @Override
    public int DEC() {
        this.fetch();
        int temp = ushort(this.fetched - 1);
        write(this.addr_abs, (short) (temp & 0x00FF));
        setFlag(Olc6502A.FLAGS6502.Z, (temp & 0x00FF) == 0x0000);
        setFlag(Olc6502A.FLAGS6502.N, (temp & 0x0080) > 0);
        return 0;
    }

    @Override
    public int DEX() {
        this.x = ubyte((short) (this.x - 1));
        setFlag(Olc6502A.FLAGS6502.Z, this.x == 0x00);
        setFlag(Olc6502A.FLAGS6502.N, (this.x & 0x80) > 0);
        return 0;
    }

    @Override
    public int DEY() {
        this.y = ubyte((short) (this.y - 1));
        setFlag(Olc6502A.FLAGS6502.Z, y == 0x00);
        setFlag(Olc6502A.FLAGS6502.N, (y & 0x80) > 0);
        return 0;
    }

    @Override
    public int EOR() {
        this.fetch();
        this.a = ubyte((short) (this.a ^ this.fetched));
        setFlag(Olc6502A.FLAGS6502.Z, this.a == 0x00);
        setFlag(Olc6502A.FLAGS6502.N, (this.a & 0x80) > 0);
        return 1;
    }

    @Override
    public int INC() {
        this.fetch();
        int temp = ushort(this.fetched + 1);
        write(this.addr_abs, (short) (temp & 0x00FF));
        setFlag(Olc6502A.FLAGS6502.Z, (temp & 0x00FF) == 0x0000);
        setFlag(Olc6502A.FLAGS6502.N, (temp & 0x0080) > 0);
        return 0;
    }

    @Override
    public int INX() {
        this.x = ubyte((short) (this.x + 1));
        setFlag(Olc6502A.FLAGS6502.Z, this.x == 0x00);
        setFlag(Olc6502A.FLAGS6502.N, (this.x & 0x80) > 0);
        return 0;
    }

    @Override
    public int INY() {
        this.y = ubyte((short) (this.y + 1));
        setFlag(Olc6502A.FLAGS6502.Z, y == 0x00);
        setFlag(Olc6502A.FLAGS6502.N, (y & 0x80) > 0);
        return 0;
    }

    @Override
    public int JMP() {
        this.pc = this.addr_abs;
        return 0;
    }

    @Override
    public int JSR() {
        this.pc = ushort(this.pc - 1);

        write(0x0100 + this.stkp, (short) ((this.pc >> 8) & 0x00FF));
        this.stkp = ubyte((short) (this.stkp - 1));
        write(0x0100 + this.stkp, (short) (this.pc & 0x00FF));
        this.stkp = ubyte((short) (this.stkp - 1));

        this.pc = this.addr_abs;
        return 0;
    }

    @Override
    public int LDA() {
        this.fetch();
        this.a = this.fetched;
        setFlag(Olc6502A.FLAGS6502.Z, a == 0x00);
        setFlag(Olc6502A.FLAGS6502.N, (a & 0x80) > 0);
        return 1;
    }

    @Override
    public int LDX() {
        this.fetch();
        this.x = this.fetched;
        setFlag(Olc6502A.FLAGS6502.Z, x == 0x00);
        setFlag(Olc6502A.FLAGS6502.N, (x & 0x80) > 0);
        return 1;
    }

    @Override
    public int LDY() {
        this.fetch();
        this.y = this.fetched;
        setFlag(Olc6502A.FLAGS6502.Z, this.y == 0x00);
        setFlag(Olc6502A.FLAGS6502.N, (this.y & 0x80) > 0);
        return 1;
    }

    @Override
    public int LSR() {
        this.fetch();
        setFlag(Olc6502A.FLAGS6502.C, (fetched & 0x0001) > 0);
        int temp = ushort(this.fetched >> 1);
        setFlag(Olc6502A.FLAGS6502.Z, (temp & 0x00FF) == 0x0000);
        setFlag(Olc6502A.FLAGS6502.N, (temp & 0x0080) > 0);
        // if (lookup[opcode].addrmode == &olc6502::IMP)
        if (lookupTable.get(opcode).addrMode.getName() == "IMP")
            this.a = ubyte((short) (temp & 0x00FF));
        else
            write(this.addr_abs, (short) (temp & 0x00FF));
        return 0;
    }

    @Override
    public int NOP() {
        switch (opcode) {
            case 0x1C:
            case 0x3C:
            case 0x5C:
            case 0x7C:
            case 0xDC:
            case 0xFC:
                return 1;
        }
        return 0;
    }

    @Override
    public int ORA() {
        this.fetch();
        this.a = ubyte((short) (this.a | this.fetched));
        setFlag(Olc6502A.FLAGS6502.Z, this.a == 0x00);
        setFlag(Olc6502A.FLAGS6502.N, (this.a & 0x80) > 0);
        return 1;
    }

    @Override
    public int PHA() {
        write(0x0100 + this.stkp, (short) this.a);
        this.stkp = ubyte((short)(this.stkp - 1));
        return 0;
    }

    @Override
    public int PHP() {
        write(0x0100 + this.stkp, (short) (this.status | Olc6502A.FLAGS6502.B.bitNo | Olc6502A.FLAGS6502.U.bitNo));
        setFlag(Olc6502A.FLAGS6502.B, false);
        setFlag(Olc6502A.FLAGS6502.U, false);
        this.stkp = ubyte((short) (this.stkp - 1));
        return 0;
    }

    @Override
    public int PLA() {
        this.stkp = ubyte((short) (this.stkp + 1));
        this.a = read(0x0100 + stkp);
        setFlag(Olc6502A.FLAGS6502.Z, a == 0x00);
        setFlag(Olc6502A.FLAGS6502.N, (a & 0x80) > 0);
        return 0;
    }

    @Override
    public int PLP() {
        this.stkp = ubyte((short) (this.stkp + 1));;
        this.status = read(0x0100 + this.stkp);
        setFlag(Olc6502A.FLAGS6502.U, true);
        return 0;
    }

    @Override
    public int ROL() {
        this.fetch();
        int temp = ushort(ushort((fetched << 1)) | getFlag(Olc6502A.FLAGS6502.C));
        setFlag(Olc6502A.FLAGS6502.C, (temp & 0xFF00) > 0);
        setFlag(Olc6502A.FLAGS6502.Z, (temp & 0x00FF) == 0x0000);
        setFlag(Olc6502A.FLAGS6502.N, (temp & 0x0080) > 0);
        // if (lookup[opcode].addrmode == &olc6502::IMP)
        if (lookupTable.get(opcode).addrMode.getName() == "IMP")
            this.a = ubyte((short) (temp & 0x00FF));
        else
            write(this.addr_abs, (short) (temp & 0x00FF));
        return 0;
    }

    @Override
    public int ROR() {
        this.fetch();
        int temp = ushort(ushort(getFlag(Olc6502A.FLAGS6502.C) << 7) | (this.fetched >> 1));
        setFlag(Olc6502A.FLAGS6502.C, (this.fetched & 0x01) > 0);
        setFlag(Olc6502A.FLAGS6502.Z, (temp & 0x00FF) == 0x00);
        setFlag(Olc6502A.FLAGS6502.N, (temp & 0x0080) > 0);
        // if (lookup[opcode].addrmode == &olc6502::IMP)
        if (lookupTable.get(opcode).addrMode.getName() == "IMP")
            this.a = ubyte((short) (temp & 0x00FF));
        else
            write(this.addr_abs, (short) (temp & 0x00FF));
        return 0;
    }

    @Override
    public int RTI() {
        this.stkp = ubyte((short) (this.stkp + 1));
        this.status = read(0x0100 + this.stkp);
        this.status &= ~(1 << 4);
        this.status &= ~(1 << 5);

        this.stkp = ubyte((short) (this.stkp + 1));
        this.pc = ushort(read(0x0100 + this.stkp));
        this.stkp = ubyte((short) (this.stkp + 1));
        this.pc |= ushort(read(0x0100 + this.stkp)) << 8;
        return 0;
    }

    @Override
    public int RTS() {
        this.stkp = ubyte((short) (this.stkp + 1));
        this.pc = ushort(read(0x0100 + stkp));
        this.stkp = ubyte((short) (this.stkp + 1));
        this.pc |= ushort(read(0x0100 + stkp)) << 8;

        this.pc = ushort((this.pc + 1));
        return 0;
    }

    @Override
    public int SBC() {
        fetch();

        int value = (ushort(this.fetched)) ^ 0x00FF;
        int temp =ushort(ushort(this.a) + value + ushort(getFlag(Olc6502A.FLAGS6502.C)));
        setFlag(Olc6502A.FLAGS6502.C, (temp & 0xFF00) > 0);
        setFlag(Olc6502A.FLAGS6502.Z, (temp & 0x00FF) == 0);
        setFlag(Olc6502A.FLAGS6502.N, (temp & 0x0080) > 0);
        setFlag(Olc6502A.FLAGS6502.V, ((temp ^ ushort(this.a)) & (temp ^ value) & 0x0080) > 0);
//        SetFlag(V, (~((uint16_t)a ^ (uint16_t)fetched) & ((uint16_t)a ^ (uint16_t)temp)) & 0x0080);
        this.a = ubyte((short) (temp & 0x00FF));
        return 1;
    }

    @Override
    public int SEC() {
        setFlag(Olc6502A.FLAGS6502.C, true);
        return 0;
    }

    @Override
    public int SED() {
        setFlag(Olc6502A.FLAGS6502.D, true);
        return 0;
    }

    @Override
    public int SEI() {
        setFlag(Olc6502A.FLAGS6502.I, true);
        return 0;
    }

    @Override
    public int STA() {
        write(this.addr_abs, (short) this.a);
        return 0;
    }

    @Override
    public int STX() {
        write(this.addr_abs, (short) this.x);
        return 0;
    }

    @Override
    public int STY() {
        write(this.addr_abs, (short) this.y);
        return 0;
    }

    @Override
    public int TAX() {
        this.x = this.a;
        setFlag(Olc6502A.FLAGS6502.Z, x == 0x00);
        setFlag(Olc6502A.FLAGS6502.N, (x & 0x80) > 0);
        return 0;
    }

    @Override
    public int TAY() {
        this.y = this.a;
        setFlag(Olc6502A.FLAGS6502.Z, y == 0x00);
        setFlag(Olc6502A.FLAGS6502.N, (y & 0x80) > 0);
        return 0;
    }

    @Override
    public int TSX() {
        this.x = this.stkp;
        setFlag(Olc6502A.FLAGS6502.Z, x == 0x00);
        setFlag(Olc6502A.FLAGS6502.N, (x & 0x80) > 0);
        return 0;
    }

    @Override
    public int TXA() {
        this.a = this.x;
        setFlag(Olc6502A.FLAGS6502.Z, a == 0x00);
        setFlag(Olc6502A.FLAGS6502.N, (a & 0x80) > 0);
        return 0;
    }

    @Override
    public int TXS() {
        this.stkp = this.x;
        return 0;
    }

    @Override
    public int TYA() {
        this.a = this.y;
        setFlag(Olc6502A.FLAGS6502.Z, a == 0x00);
        setFlag(Olc6502A.FLAGS6502.N, (a & 0x80) > 0);
        return 0;
    }

    @Override
    public int XXX() {
        return 0;
    }

}
