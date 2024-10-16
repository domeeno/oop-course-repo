#include <iostream>
#include <fstream>
#include "../include/nlohmann/json.hpp"
#include <vector>
#include <string>

using json = nlohmann::json;
using namespace std;

class Universe {
private:
    string name;
    vector<json> individuals;
public:
    Universe(const string& name) : name(name) {}
    void setIndividuals(json individual){
        individuals.push_back(individual);
    }
    auto getIndividuals(){
        return individuals;
    }

    string getName(){
        return name;
    }
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
            starWars.setIndividuals(entry);
        } else if (userInput == "2") {
            hitchhikers.setIndividuals(entry);
        } else if (userInput == "3") {
            marvel.setIndividuals(entry);
        } else if (userInput == "4") {
            rings.setIndividuals(entry);
        } else {
            cout << "Invalid input" << endl;
        }
    }

    ofstream outStarWars("../resources/output/star-wars.json");
    ofstream outHitchhikers("../resources/output/hitch-hiker.json");
    ofstream outMarvel("../resources/output/marvel.json");
    ofstream outRings("../resources/output/rings.json");
    outStarWars << json({{"name", starWars.getName()}, {"individuals", starWars.getIndividuals()}}).dump(4);
    outHitchhikers << json({{"name", hitchhikers.getName()}, {"individuals", hitchhikers.getIndividuals()}}).dump(4);
    outMarvel << json({{"name", marvel.getName()}, {"individuals", marvel.getIndividuals()}}).dump(4);
    outRings << json({{"name", rings.getName()}, {"individuals", rings.getIndividuals()}}).dump(4);

    cout << "Success! Files have been written." << endl;
    return 0;
}
