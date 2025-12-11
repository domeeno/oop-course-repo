# oop-learning-hooray

Please read in the editing mode as the schema won't load properly otherwise!

 ---------------------------         --------------------------          --------------------------
|         Population        |--     |         Country          |    ----|            GDP           |
|---------------------------|  |    |--------------------------|   |    |--------------------------|
|                           |  |    | - name: string           |   |    | - per_capita: double     |
| - total: long             |  |    | - area: double           |   |    | - per_capita_ppp: double |
| - nationalities: string[] |  -- > | - population: Population |   |    | - gni: double            |
|---------------------------|       | - gdp: GDP               | <--    |--------------------------|
| + get_density()           |       |--------------------------|        | + get_per_capita()       |
| + get_total()             |       | + get_name()             |        | + get_per_capita_ppp()   |
| + get_nations()           |       | + get_area()             |        | + get_gni()              |
 ---------------------------        | + get_population()       |         --------------------------
                                    | + get_gdp()              |
                                    | + show_info()            | 
                                     --------------------------

This is the schema that represents the system assigned to me in the first lab.
There were several changes made to it.
Firstly, I made it so that the attributes in each object are private to ensure encapsulation - a principle in OOP that bundles attributes and methods into a single class to ensure protection of data.
Secondly, I added a method "show_info()" which displays the information added via constructor.

When I asked the AI for feedback, it suggested renaming the get methods, i.e. "get_value" becomes "getValue". Also, it suggested adding an actual method in Country that would calculate the population density, making more sense as density is basically entire population divided by area, instead of some hardcoded value.

My friend who is a C# developer also told me about the density being calculated would be nice, so I finally added that method.
