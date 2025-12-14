# Data Types

Data types are divided into two groups:
- **Primitive data types**: `byte`, `short`, `int`, `long`, `float`, `double`, `boolean`, `char`.
- **Non-primitive data types**: `Strings`, `Arrays`, `Classes`.
  
  
## Primitive Data Types in Java

Java has **8 primitive data types**:

| Data Type | Size (bytes) | Range (For Numbers)                  |
|-----------|--------------|--------------------------------------|
| byte      | 1            | [-128 to 127]                        |
| short     | 2            | [-32,768 to 32,767]                 |
| int       | 4            | [-2,147,483,648 to 2,147,483,647]   |
| long      | 8            | [-9,223,372,036,854,775,808 to 9,223,372,036,854,775,807] |
| float     | 4            | Approximately ±3.40282347E+38 (6-7 significant decimal digits) |
| double    | 8            | Approximately ±1.79769313486231570E+308 (15 significant decimal digits) |
| char      | 2            | 0 to 65,535 (Unicode characters)    |
| boolean   | 1            | true or false                        |

#### Notes:
- The range for numeric types is calculated using the formula:  
  `[-2^(n-1) ; 2^(n-1) - 1]`  
  where **n** is the size of the type in bits.

---

## Characters
Characters in Java are encoded using **UTF-16** (size = 16 bits = 2 bytes)
It supports both **ASCII values** and **full Unicode** characters.

> Java `char` represents **one UTF-16 code unit**, not necessarily one full Unicode character
> Java `String` internally stores text as a **sequence of UTF-16 code units**

---

### Surrogate

The mechanism used in Java (and UTF-16 in general) to represent **Unicode code points greater than `U+FFFF`** (`> 65,535`).
UTF-16 can directly represent characters in the range `U+0000` → `U+FFFF` (the **Basic Multilingual Plane**).
To represent characters above that range, UTF-16 uses **two 16-bit `char` values** - called a **surrogate pair**:

* **High surrogate:** `0xD800–0xDBFF`
* **Low surrogate:** `0xDC00–0xDFFF`

Together they represent a single code point in the range `U+10000–U+10FFFF`.

---

### Misleading Length

```java
String s = "😀";
int len = s.length();                // 2 (UTF-16 code units)
int real = s.codePointCount(0, s.length()); // 1 (actual Unicode character)
```

`String.length()` counts **UTF-16 code units**, not Unicode characters.
That’s why `"😀"`, which is one Unicode code point, reports a length of 2 — it’s stored as **two surrogate `char`s**.

> `1 char` ≠ `1 character`

---

### Notes

* `char` literals use **single quotes**, e.g. `'A'`, `'中'`
* `String` literals use **double quotes**, e.g. `"Hello"`
* You can assign numeric values to `char` (ASCII or Unicode code unit):
  ```java
  char c = 65; // 'A'
* Use `codePointAt()` and `codePoints()` to safely handle full Unicode characters.
