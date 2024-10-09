import json
import os

class Universe:
    def __init__(self, name, individuals):
        self.name = name
        self.individuals = individuals


def main():
    starWars = Universe("starwars", [])
    hitchHiker = Universe("hitchHiker", [])
    rings = Universe("rings", [])
    marvel = Universe("marvel", [])

    file_path = os.path.join("../resources", "input.json")

    try:
        with open(file_path) as input_file:
            data = json.load(input_file)
            for node in data['data']:
                #print(node)
                if node is not None:
                    choice = input("Enter the number of the universe: ")
                    while int(choice)  < 1 or int(choice) > 4:
                        choice = input("Enter the number of the universe BETWEEN 1 AND 4: ")
                    if choice == "1":
                        starWars.individuals.append(node)
                    elif choice == "2":
                        hitchHiker.individuals.append(node)
                    elif choice == "3":
                        rings.individuals.append(node)
                    elif choice == "4":
                        marvel.individuals.append(node)

            output_dir = os.path.join("../resources", "output")
            universe_individuals = [starWars.individuals, hitchHiker.individuals, rings.individuals, marvel.individuals]
            output_filenames = ["star-wars.json", "hitch_hiker.json", "rings.json", "marvel.json"]
            for i in range(len(universe_individuals)):
                if universe_individuals[i] is not None:
                    with open(os.path.join(output_dir, output_filenames[i]), 'w') as f:
                        json.dump(universe_individuals[i], f)

    except FileNotFoundError:
        print(f"Error: File not found at {file_path}")


if __name__ == "__main__":
    main()
