package org.example;

import java.util.HashSet;
import java.util.Set;

public class Module {
    private String name;
    private Set<Module> dependencies;

    public Module(String name) {
        this.name = name;
        this.dependencies = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void addDependency(Module module) {
        dependencies.add(module);
    }

    public Set<Module> getDependencies() {
        return dependencies;
    }
}