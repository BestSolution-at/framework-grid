#! /usr/bin/env python3

import sys
import random
import os
from faker import Factory as FFactory

OUTFILE = "samples.xmi"

NUM_SAMPLES = 10
NUM_COUNTRIES = 4

TEMPLATE = """<?xml version="1.0" encoding="ASCII"?>
<person:Root
    xmi:version="2.0"
    xmlns:xmi="http://www.omg.org/XMI"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:person="http://www.bestsolution.at/framework/grid/personsample/1.0"
    xsi:schemaLocation="http://www.bestsolution.at/framework/grid/personsample/1.0 ../model/Person.xcore#/EPackage">
{0}
</person:Root>
"""

TEMPLATE_COUNTRY = """<countries name="{0}"/>"""

TEMPLATE_PERSON = """<persons firstname="{0}"
      lastname="{1}"
      gender="{2}"
      married="{3}"
      birthdate="{4}">
    <address
        street="{5}"
        number="{6}"
        zipcode="{7}"
        city="{8}"
        country="//@countries.{9}"/>
  </persons>
"""

COUNTRIES = []
PERSONS = []


def fake_xmi():
    faker = FFactory.create()
    for i in range(NUM_SAMPLES):
        PERSONS.append(
            TEMPLATE_PERSON.format(
                faker.first_name(),
                faker.last_name(),
                "MALE" if faker.boolean() is True else "FEMALE",
                faker.boolean(),
                faker.iso8601(),
                faker.street_name(),
                faker.building_number(),
                faker.postcode(),
                faker.city(),
                random.randint(0, NUM_COUNTRIES - 1)
            )
        )

    for i in range(NUM_COUNTRIES):
        COUNTRIES.append(
            TEMPLATE_COUNTRY.format(faker.country())
        )

    with open(OUTFILE, "w") as text_file:
        text_file.write(
            TEMPLATE.format(
                os.linesep.join(
                    [os.linesep.join(PERSONS), os.linesep.join(COUNTRIES)]
                )
            )
        )


if __name__ == "__main__":
    if "-n" in sys.argv:
        position_param = sys.argv.index("-n")
        NUM_SAMPLES = int(sys.argv[position_param + 1])
        sys.argv.pop(position_param)
        sys.argv.pop(position_param)

    if len(sys.argv) > 1:
        OUTFILE = sys.argv.pop()

    print("Writing samples to {0}.".format(OUTFILE))

    fake_xmi()
