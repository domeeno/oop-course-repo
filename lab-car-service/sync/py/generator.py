import json
import random

# Constants
NR_OF_GENERATIONS = 30

# Car properties
CAR_TYPES = ["ELECTRIC", "GAS"]
PASSENGER_TYPES = ["PEOPLE", "ROBOTS"]
IS_DINING = [True, False]
CONSUMPTION_RANGE = (10, 50)

# Statistics
STATS = {
    "ELECTRIC": 0,
    "GAS": 0,
    "PEOPLE": 0,
    "ROBOTS": 0,
    "DINING": 0,
    "NOT_DINING": 0,
    "CONSUMPTION": {"ELECTRIC": 0, "GAS": 0}
}

if __name__ == "__main__":

    all_cars = []

    for i in range(1, NR_OF_GENERATIONS + 1):
        cartype = random.choice(CAR_TYPES)
        passengers = random.choice(PASSENGER_TYPES)
        isDining = random.choice(IS_DINING)
        consumption = random.randint(*CONSUMPTION_RANGE)

        # update stats
        STATS[cartype] += 1
        STATS[passengers] += 1
        STATS["DINING" if isDining else "NOT_DINING"] += 1
        STATS["CONSUMPTION"][cartype] += consumption

        car = {
            "id": i,
            "type": cartype,
            "passengers": passengers,
            "isDining": isDining,
            "consumption": consumption,
        }

        all_cars.append(car)

    # Write single file with all cars
    with open("cars.json", "w") as f:
        json.dump(all_cars, f, indent=4)

    # Print stats (optional)
    print(json.dumps(STATS, indent=4))
