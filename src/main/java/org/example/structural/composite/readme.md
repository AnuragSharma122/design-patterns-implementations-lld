# Composite pattern:    
 
## Consequences
> It defines class hierarchies consisting of primitive objects and composite objects. 
Primitive objects can be composed into more complex objects, which in turn can be
composed, and so on recursively. Wherever client code expects a primitive object,
it can also take a composite object.

> It makes the client simple. Clients can treat composite structures and individual objects
uniformly. Clients normally don't know (and shouldn't care) whether they're dealing with
leaf or a composite component. It avoids client to write tag and case statement style functions
over the classes that define composition.

> It makes it easier to add new kinds of components. Newly defined Composite or Leaf
subclasses work automatically with existing structures and client code. Client
don't have to changes for new component classes.

> The disadvantage is that it can make design overly general. It makes it harder
to restrict the components of a composite. Sometimes you want to have only certain
components. With composite, you can't rely on the type system to enforce those constraints
for you. You'll have to use run-time checks instead.

> Composite pattern’s strength is uniformity — everything (leaf or composite) implements the same interface. 
> But this uniformity also means you lose type safety.
> 
> For example: You might want a Folder to contain only File objects —
but since both File and Folder are FileSystemComponent,
the compiler happily allows folder.add(anotherFolder).


## 🧩 Implementation — Parent References in Composite

> Normally, in the **Composite Pattern**, relationships are **one-directional** — only *downward*.

### 📂 Typical Structure
Folder
├── File
└── File

In this model:
- Each **Folder** knows its **children**.
- But each **child (File)** does **not** know its **parent**.

---

### 🔗 Introducing Parent References

By adding a `parent` field to each `FileSystemComponent`,  
every child also holds a reference to its **parent folder**.

This enables **bidirectional navigation** in the hierarchy: Folder ↔ File


---

### 💡 Why Parent References Help

#### 🧭 1. Easy Upward Traversal
You can move from any child to its parent.  
Example: When deleting a file, the file can directly ask its parent to remove it.

```java
file.getParent().remove(file);
