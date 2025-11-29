# Experiment 3

> This is an immutable List of enums, where each Enum constant
> is processed and stored by its index.
> 
> This stores an integer, instead of an enum constant. Since enum constants
> are static, this may not bring much benefit at all.
> 
> When doing any look-ups, retrievals, or any comparisons, there is a cost
> for converting the enum constant to its index, and vice versa.
> 
