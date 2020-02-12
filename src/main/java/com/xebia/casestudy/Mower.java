package com.xebia.casestudy;

public class Mower {

    private Location location;

    public Mower(Location location) {
        this.location = location;
    }

    public Location move(String instruction,Lawn  lawn) {
        char [] instructions = instruction.replaceAll("\\s+","").toCharArray();
        for (int i = 0; i < instructions.length ; i++) {
            location= executeInstruction(instructions[i],lawn);
        }
        return location;
    }

    private Location executeInstruction( char instruction, Lawn  lawn) {
        InstructionProcess instructionProcess = new InstructionProcess();
        if(instruction=='A')
            return instructionProcess.advance(location, lawn);
        return instructionProcess.turn(location,String.valueOf(instruction));
    }
}
