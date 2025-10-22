# Classification: Individual attributes

An `Individual` representing their species of a universe will have 5 attributes, an id attribute and 4 optional descriptive attributes, values for which **can** be `null` or `undefined`.

1. id - unique identifier (int)
2. isHumanoid - does the individual reflect human features (boolean)
3. originPlanet - planet of origin of the being (string/enum)
4. age - age of the being (int)
5. physicalTraits - some physical characteristics of the being (array: []string/[]enum)

**isHumanoid** (boolean):
- true,
- false

**originPlanet** (string/enum):
- EARTH,
- ASGARD,
- BETELGEUSE,
- VOGSPHERE,
- KASHYYYK,
- ENDOR

**age** (int)
- an integer value falling into a range (check classification below for ranges).

**physicalTraits:** (string/enum):
- HAIRY,
- TALL,
- SHORT,
- BLONDE,
- EXTRA_ARMS,
- EXTRA_HEAD,
- GREEN,
- BULKY,
- POINTY_EARS,

# Classification: Universe

An individual can be a part of the following species, which belong to a specific universe, use these rules to tell the individual instances' universe.

## Undefined Universe

If there is not enough information to determine an Individual's universe with certainty, it would go in an undefined list, in other words, it requires more information. Otherwise, it would go in one of the 4 lists below.

## Star Wars Species

### (Wookie)

```
isHumanoid: false
originPlanet: KASHYYYK
age: 0-400
physicalTraits: [HAIRY, TALL]
```

### (Ewok)

```
isHumanoid: false
originPlanet: ENDOR
age: 0-60
physicalTraits: [SHORT, HAIRY]
```

## Marvel Species

### (Asgardian)

```
isHumanoid: true
originPlanet: ASGARD
age: 0-5000
physicalTraits: [BLONDE, TALL]
```

## Hitchhiker's Species

### (Betelgeusian)

```
isHumanoid: true
originPlanet: BETELGEUSE
age: 0-100
physicalTraits: [EXTRA_ARMS, EXTRA_HEAD]
```

### (Vogon)

```
isHumanoid: false
originPlanet: VOGSPHERE
age: 0-200
physicalTraits: [GREEN, BULKY]
```

## Lord of the rings Species

### (Elf)

```
isHumanoid: true
originPlanet: EARTH
age: 0-MAX (could be > 5000)
physicalTraits: [BLONDE, POINTY_EARS]
```

### (Dwarf)

```
isHumanoid: true
originPlanet: EARTH
age: 0-200
physicalTraits: [SHORT, BULKY]
```

