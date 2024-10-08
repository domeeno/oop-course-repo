# Intro laboratory

## Objective.

This lab is inspired by the game: Papers, Please.

The primary task in the game is for the player to decide whether to grant or deny individuals entry into the city, based on their papers data.

The lab builds on the premise, but has some modified rules and background story, for a more light-hearted experience.

## Story background.

In a distant future, a software engineering intern has force pushed some untested code before the deadline to the multiverse codebase.

This mishap by the intern has caused the merging and colliding of our Moldavian Universe with a few fictional ones.

Even though the locals remained, individuals from the foreign universes have suddenly appeared. The foreigners even though curious about the Moldovian culture, want to get back to their own universes.

The issue is, they have no idea what the mutliverse is, and where do they belong.

## The solution

The Senior students of the Technical University of Moldova, being well-versed in pop-culture, recognize that the visitors can be sorted into four finctional universes.

A classification system is therefore agreed upon and documented in `classification.md`, the only thing remaining is to streamline the process of sending these travelers back to their correct universes.

Using the classification system, and an input file of all the registered individuals, the only thing left is to write an Object-Oriented system that does the automated classification.

### Inspirations for universes:

- Book - The Hitchhicker's guide to the galaxy

- Marvel Universe

- Star Wars Universe

- Lord of the Rings Universe

## Technical

`input.json` contains the list of the individuals. Some entries have full info, some partial. Using the Classification in `classification.md` write to 4 output files the grouped result per universe.

`output` folder is how your end solution should write the files.

Some primitive solutions for a few languages have been provided by the government and are stored in `<language>-classification`. They are slow and manual, but decent place to experiment and start the final solution. Feel free to copy and build from those.
