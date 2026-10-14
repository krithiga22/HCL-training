
package com.hcl.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeBugDemo {

    static class BrokenEmployee {
        private int id;
        private String name;

        public BrokenEmployee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (!(obj instanceof BrokenEmployee other)) {
                return false;
            }

            return this.id == other.id;
        }

        // BUG: hashCode() is deliberately not overridden.
    }

    static class FixedEmployee {
        private int id;
        private String name;

        public FixedEmployee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (!(obj instanceof FixedEmployee other)) {
                return false;
            }

            return this.id == other.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== BROKEN VERSION =====");

        Map<BrokenEmployee, String> brokenMap = new HashMap<>();

        BrokenEmployee b1 = new BrokenEmployee(101, "Priya");
        BrokenEmployee b2 = new BrokenEmployee(101, "Priya");

        brokenMap.put(b1, "Employee details");

        System.out.println("Objects equal: " + b1.equals(b2));
        System.out.println("Lookup result: " + brokenMap.get(b2));

        System.out.println("\n===== FIXED VERSION =====");

        Map<FixedEmployee, String> fixedMap = new HashMap<>();

        FixedEmployee f1 = new FixedEmployee(101, "Priya");
        FixedEmployee f2 = new FixedEmployee(101, "Priya");

        fixedMap.put(f1, "Employee details");

        System.out.println("Objects equal: " + f1.equals(f2));
        System.out.println("Same hash code: "
                + (f1.hashCode() == f2.hashCode()));
        System.out.println("Lookup result: " + fixedMap.get(f2));
    }
}