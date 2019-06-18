require: dict/hh_cities.csv
  name = hh_cities

require: dict/ready.csv
  name = ready

require: dict/other_countries.csv
  name = other_countries

require: dict/sex.csv
  name = sex

require: dict/citizenship.csv
  name = citizenship

require: dict/city.csv
  name = city

patterns:

  $hh_cities = $entity<hh_cities>

  $ready = $entity<ready>

  $other_countries = $entity<other_countries>

  $sex = $entity<sex>

  $citizenship = $entity<citizenship>

  $city = $entity<city>

