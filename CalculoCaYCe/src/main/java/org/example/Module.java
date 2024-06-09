package org.example;

import java.util.HashSet;
import java.util.Set;

public class Module {
    private String name;
    private Set<Module> dependencies;
    private Set<Module> dependents;

    public Module(String name) {
        this.name = name;
        this.dependencies = new HashSet<>();
        this.dependents = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void addDependency(Module module) {
        dependencies.add(module);
    }

    public void addDependent(Module module) {
        dependents.add(module);
    }

    public Set<Module> getDependencies() {
        return dependencies;
    }
    public Set<Module> getDependents(){
        return dependents;
    }
}