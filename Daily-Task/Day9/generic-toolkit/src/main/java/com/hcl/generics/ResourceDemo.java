package com.hcl.generics;

public class ResourceDemo {

    static class DemoResource implements AutoCloseable {

        private final String name;

        DemoResource(String name) {
            this.name = name;
            System.out.println(name + " opened");
        }

        @Override
        public void close() {
            System.out.println(name + " closed");
        }
    }

    public static void main(String[] args) {

        try (DemoResource first = new DemoResource("Resource A");
             DemoResource second = new DemoResource("Resource B")) {

            System.out.println("Using resources");
        }

        System.out.println("Program finished");
    }
}
