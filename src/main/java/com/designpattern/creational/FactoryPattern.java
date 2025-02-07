package com.designpattern.creational;

// Product Interface
interface Logger {
    void log(String message);
}

// Concrete Product Classes
class ConsoleLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println("Console Logger: " + message);
    }
}

class FileLogger implements Logger {

    @Override
    public void log(String message){
        System.out.println("File Logger :" + message);
    }
}

class DatabaseLogger implements Logger {

    @Override
    public void log(String message){
        System.out.println("Database Logger :" + message);
    }
}

// Factory Class
class LoggerFactory {
    public static Logger getLogger(String type) {
        return switch (type){
            case "console" -> new ConsoleLogger();
            case "file" -> new FileLogger();
            case "database" -> new DatabaseLogger();
            default -> throw new IllegalStateException("Unknown Logger Type: " + type);
        };
    }
}

public class FactoryPattern {
    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger("console");
        logger.log("This is console log message");

        logger = LoggerFactory.getLogger("file");
        logger.log("This is file log message");

        logger = LoggerFactory.getLogger("database");
        logger.log("This is database log message");
    }
}
