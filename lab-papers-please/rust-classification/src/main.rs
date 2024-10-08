use serde::{Deserialize, Serialize};
#[allow(dead_code)]
#[allow(unused_mut)]
#[allow(unused_imports)]
#[allow(unused_variables)]
use serde_json::{Result, Value};
use std::{fs, io};
// import file io
// ...
#[derive(Debug, Serialize, Deserialize)]
struct Data {
    data: Vec<Character>,
}

#[derive(Debug, Serialize, Deserialize)]
struct Character {
    id: u32,
    isHumanoid: Option<bool>, // Optional, since it's missing in some entries
    planet: Option<String>,   // Optional, since it's missing in some entries
    age: Option<u32>,
    traits: Option<Vec<String>>, // Optional, since it's missing in some entries
}

fn main() {
    // read the test-input.json
    let file_data =
        fs::read_to_string("../resources/test-input.json").expect("failed to read file");
    println!("{file_data}");
    let data: Data = serde_json::from_str(file_data.as_str()).expect("failed to parse json");

    println!("json data: {data:?}");
    let mut star_wars: Vec<Character> = vec![];
    let mut hitch_hicker: Vec<Character> = vec![];
    let mut rings: Vec<Character> = vec![];
    let mut marvel: Vec<Character> = vec![];

    // iterate over the data(json objects not lines), read from std input which one
    // it is (1,2,3,4), then append it

    for line in data.data {
        println!("new line: {line:?}");

        let mut buffer = String::new();
        io::stdin()
            .read_line(&mut buffer)
            .expect("failed to read from stdin");

        match buffer.as_str().trim() {
            "1" => star_wars.push(line),
            "2" => hitch_hicker.push(line),
            "3" => rings.push(line),
            "4" => marvel.push(line),
            _ => println!("WRONG!"),
        }
    }
    // write each string as a .json in resources/output/_.json
    fs::write(
        "../resources/output/star-wars.json",
        serde_json::to_string(&star_wars).expect("failed to deserialize star wars"),
    );
    fs::write(
        "../resources/output/hitch_hicker.json",
        serde_json::to_string(&hitch_hicker).expect("failed to deserialize star wars"),
    );
    fs::write(
        "../resources/output/rings.json",
        serde_json::to_string(&rings).expect("failed to deserialize star wars"),
    );
    fs::write(
        "../resources/output/marvel.json",
        serde_json::to_string(&marvel).expect("failed to deserialize star wars"),
    );
}
