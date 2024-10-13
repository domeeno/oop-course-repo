#include <iostream>
#include <fstream>
#include "nlohmann/json.hpp"
#include <vector>
#include <string>

using json = nlohmann::json;
using namespace std;

class Universe {
public:
    string name;
    vector<json> individuals;

    Universe(const string& name) : name(name) {}
};

int main() {
    ifstream inputFile("../resources/test-input.json");
    if (!inputFile) {
        cerr << "Error: Could not open the input file!" << endl;
        return 1;
    }

    json inputJson;
    inputFile >> inputJson;
    json data = inputJson["data"];
    
    Universe starWars("star-wars");
    Universe hitchhikers("hitch-hiker");
    Universe marvel("marvel");
    Universe rings("rings");

    string userInput;
    for (const auto& entry : data) {
        cout << entry.dump() << endl; 
        cin >> userInput;

        if (userInput == "1") {
            starWars.individuals.push_back(entry);
        } else if (userInput == "2") {
            hitchhikers.individuals.push_back(entry);
        } else if (userInput == "3") {
            marvel.individuals.push_back(entry);
        } else if (userInput == "4") {
            rings.individuals.push_back(entry);
        } else {
            cout << "Invalid input" << endl;
        }
    }

    ofstream outStarWars("../resources/output/star-wars.json");
    ofstream outHitchhikers("../resources/output/hitch-hiker.json");
    ofstream outMarvel("../resources/output/marvel.json");
    ofstream outRings("../resources/output/rings.json");

    outStarWars << json({{"name", starWars.name}, {"individuals", starWars.individuals}}).dump(4);
    outHitchhikers << json({{"name", hitchhikers.name}, {"individuals", hitchhikers.individuals}}).dump(4);
    outMarvel << json({{"name", marvel.name}, {"individuals", marvel.individuals}}).dump(4);
    outRings << json({{"name", rings.name}, {"individuals", rings.individuals}}).dump(4);

    cout << "Success! Files have been written." << endl;
    return 0;
}
