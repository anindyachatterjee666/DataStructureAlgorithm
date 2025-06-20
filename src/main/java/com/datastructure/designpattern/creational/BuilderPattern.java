package com.datastructure.designpattern.creational;


import lombok.Builder;
import lombok.Data;

class Computer {
    private String HDD;
    private String RAM;
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;

//    getters
    public String getHDD() {
        return HDD;
    }

    public String getRAM() {
        return RAM;
    }

    public boolean isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

//    private constructor
    private Computer (ComputerBuilder builder){

        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

//    static inner ComputerBuilder class
    public static class ComputerBuilder {
        private String HDD;
        private String RAM;
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

//        Constructor
        public ComputerBuilder(String HDD, String RAM){
//                               boolean isGraphicsCardEnabled, boolean isBluetoothEnabled) {
            this.HDD = HDD;
            this.RAM = RAM;
//            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
//            this.isBluetoothEnabled = isBluetoothEnabled;
        }

        public ComputerBuilder setGraphicsCardEnabled(boolean graphicsCardEnabled) {
            this.isGraphicsCardEnabled = graphicsCardEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean bluetoothEnabled) {
            this.isBluetoothEnabled = bluetoothEnabled;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }
    }
}


// main
public class BuilderPattern {
    public static void main(String[] args) {

//        create computer object using Builder
        Computer computer = new Computer.ComputerBuilder("HDD", "4")
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();

        System.out.println(computer.getHDD());
        System.out.println(computer.getRAM());
        System.out.println(computer.isGraphicsCardEnabled());
        System.out.println(computer.isBluetoothEnabled());
    }
}
