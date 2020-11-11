# OpenClassrooms-Project5

The project implemented is the SafetyNet Alerts application.

Its main purpose is to send emergency information to emergency responders.

For instance, if there is a fire, SafetyNet Alerts brings up information 
about the people in the house that is on fire, such as their phone numbers. 
Another example is if there is a severe storm warning, SafetyNet Alerts 
notifies all the people in the area of the storm via text message. 
To do this SafetyNet Alerts gets the phone numbers of every resident 
who lives in homes near the storm area.
In the event of a flood alert, it helps to dispatch responders with specialized 
information about everyone in the area. It provides information about every person who could 
be in the flood, their ages, and any specific medical information about them, 
such as their medications and allergies.

SafetyNet Alerts has Springboot endpoints that yield information about its status. 
The set of endpoints is health, info, metrics, and trace. 

For all endpoints, the results is JSON, and if there is an address or 
fire station number not found within the data file, it returns an empty JSON object. 

There is a set of unit tests that test each of the requirements and validates 
that the application working correctly.These unit tests are following the testing pyramid 
paradigm. 

The application logs every request and every response.

SafetyNet Alerts is architected following the Model-View-Controller design pattern.

When developing the application TDD and Agile techniques are used.
Following are the user stories and the acceptance criteria defining the behaviour of the application:

1. As an emergency responder, I want to be able to get a list of people serviced by a
specific fire station including these details: first name, last name, 
address, phone number.As well, it should provide a summary of the number of 
adults in the service area, and the number of children(anyone aged 18 and younger), 
so I can reach them with information about an emergency situation.

| ID      | GIVEN      | WHEN      | THEN     |
| ---     | ---        | ---       | ---      |
| 1 | I am an user and there is database with people living in certain area, serviced by specific fire station | I send a request with fire station number | A list is produced that consist of people's first, last name, address, phone number and summary of the number of adults in the service area, and summary of the number of the children | 
| 2 | I am an user and there is database with no people living in certain area, serviced by specific fire station | I send a request with fire station number | An empty list is returned | 


2. As an emergency responder, I want to be able to get a list of children
(anyone under the age of 18) living at specific address including the first and 
last name of each child, the child's age, and a list of other people living at that
address, so I can look after them when an emergency situation arise at that address.

| ID      | GIVEN      | WHEN      | THEN     |
| ---     | ---        | ---       | ---      |
| 3 | I am an user and there is database with people living at specific address | I send a request with specific address | A list of children living at that address is produced that consists of first name, last name and the age of the child along with a list with other persons living at that address |
| 4 | I am an user and there is database with no children living at specific address | I send a request with specific address | An empty string is returned |

3. As an emergency responder, I want to be able to get a list of phone numbers of each
person within specific fire station's jurisdiction, so I can send emergency text 
messages to specific households.

| ID      | GIVEN      | WHEN      | THEN     |
| ---     | ---        | ---       | ---      |
| 5 | I am an user and there is database with people living in area under specific fire station's jurisdiction | I send a request with fire station number | A list with phone numbers of all people within this fire station's jurisdiction is returned |
| 6 | I am an user and there is database with no people living in area under specific fire station's jurisdiction | I send a request with fire station number | An empty list is returned |

1. As an emergency responder, I want to be able to get the fire station number that services 
a specific address, as well as a list of all the people living at the address that 
includes a name, phone number and age of all person, and any medications(with dosage) 
and allergies, so I can get help in an emergency situation as well to be able to 
allocate and help all people at that address.

| ID      | GIVEN      | WHEN      | THEN     |
| ---     | ---        | ---       | ---      |
| 7 | I am an user and there is database with addresses, each linked to specific fire station and each linked to all people living at this address | I send a request with address | A fire station number is returned that services that specific address, along with list of all people living at that address, with each person's name, phone number, age, medications with dosage and allergies |
| 8 | I am an user and there is database with no addresses | I send a request with address | An empty list is returned |

1. As an emergency responder, I want to be able to get a list of all the households under 
the jurisdiction of all the fire station in a list with fire stations. The list needs to 
group people by household address, include a name, phone number and age of each person, 
and any medications(with dosage) and allergies beside each person's name, so I know in 
case of flood, whereabouts and how many people are in the endangered area.

| ID      | GIVEN      | WHEN      | THEN     |
| ---     | ---        | ---       | ---      |
| 9 | I am an user and there is database with fire stations, each related to list of households | I send a request with list of fire stations | A list is returned with all households in each fire station's jurisdiction. List should group people by household address, include name, number, age, medications (with dosages) and allergies beside each person's name |
| 10 | I am an user and there is database fire stations, each related to no households | I send a request with list of fire stations | An empty list is returned |

1. As an emergency responder , I want to be able to get person's info by passing first name and 
last name as parameter, so I have the person's name, address, age, email, list of medications 
with dosages and allergies in case the person has involved in an emergency situation .

| ID      | GIVEN      | WHEN      | THEN     |
| ---     | ---        | ---       | ---      |
| 11 | I am an user and there is database with people's info | I send a request with first and last name of a person | A list is produced with person's name, address, age, email, list of medications with dosages and allergies |
| 12 | I am an user and there is database with no people | I send a request with first and last name of a person | An empty list is returned |

1. As an emergency responder, I want to be able to get list with email addresses of all people 
in a city by passing specific city as parameter, so I can send emails to all in case of 
emergency.

| ID      | GIVEN      | WHEN      | THEN     |
| ---     | ---        | ---       | ---      |
| 13 | I am an user and there is database with cities each related to its citizen's emails | I send a request with a city name | List with all citizen's emails in that city is returned |
| 14 | I am an user and there is database with cities where each do not relate to its citizen's emails | I send a request with a city name | An empty list is returned |

1. As an admin of the system, I want to be able to add a new person to the system database, so 
the database can be updated when needed.

| ID      | GIVEN      | WHEN      | THEN     |
| ---     | ---        | ---       | ---      |
| 15 | I am an admin and there is database with persons | I add a new person to the database that qualify the restrictions | A new person is created in the database with the data I provided | 
| 16 | I am an admin and there is database with persons | I add a new person to the database that do not qualify the restrictions(unique name) | A new person is not created in the database and instead meaningful message is returned |

1. As an admin of the system, I want to be able to update a person's info, so the database can 
be updated when needed.

| ID      | GIVEN      | WHEN      | THEN     |
| ---     | ---        | ---       | ---      |
| 17 | I am an admin and there is database with persons | I send a request with data da be updated to a specific person's info | The specific person info is updated and returned |
| 18 | I am an admin and there is database with persons | I send a request with unqualified data to be updated to a specific person's info | The specific person's info is not updated and meaningful message is returned |

1. As an admin of the system, I want to be able to delete a person, so the database can be updated
when needed.

| ID      | GIVEN      | WHEN      | THEN     |
| ---     | ---        | ---       | ---      |
| 19 | I am an admin and there is database with persons | I send a request for a person to be deleted | Person is deleted |
| 20 | I am an admin and there is database with persons | I send a request for a non existing person to be deleted | No person is deleted in the database and meaningful message is returned |

1. As an admin of the system, I want to able to add fire station/address mapping, so I can connect
fire station with address.

| ID      | GIVEN      | WHEN      | THEN     |
| ---     | ---        | ---       | ---      |
| 21 | I am an admin and there is database with fire stations and addresses that are mapped to each other | I add fire station/address mapping | The mapping is created |
| 22 | I am an admin and there is database with fire station and addressed that are mapped to each other | I add fire station/ address mapping where address does not exist in the database | The mapping is not created and meaningful message is returned |

1. As an admin of the system, I want to be able to update an address's fire station number, so I
can keep the database updated with correct information.

| ID      | GIVEN      | WHEN      | THEN     |
| ---     | ---        | ---       | ---      |
| 23 | I am an admin and there is database with fire stations and addresses that are mapped to each other | I update existing fire station/address mapping with new data | The mapping is updated and returned |
| 24 | I am an admin and there is database with fire stations and addresses that are mapped to each other | I update existing fire station/address mapping with unqualified data(non existing address) | The mapping is not updated and meaningful message is returned |

1. As an admin of the system, I want to be able to delete fire station/address mapping, so I can
remove unnecessary mappings from the database.

| ID      | GIVEN      | WHEN      | THEN     |
| ---     | ---        | ---       | ---      |
| 25 | I am an admin and there is database with fire stations and addresses that are mapped to each other | I send a request to delete an existing mapping | The mapping is deleted successfully |
| 26 | I am an admin and there is database with fire stations and addresses that are mapped to each other | I send a request to delete a mapping that do not exist | No mapping is deleted in the database and meaningful message is returned |

1. As an admin of the system, I want to be able to add a medical record for a person, so I can keep 
person's info correct.

| ID      | GIVEN      | WHEN      | THEN     |
| ---     | ---        | ---       | ---      |
| 27 | I am an admin and there is database with medical records for different persons | I add a new medical record for an existing person | A new medical record is created and returned |
| 28 | I am an admin and there is database with medical records for different persons | I add a new medical record for a non existing person | The record is not added and meaningful message is returned |

1. As an admin of the system, I want to be able to update a medical record for a person, so I can 
keep person's info updated.

| ID      | GIVEN      | WHEN      | THEN     |
| ---     | ---        | ---       | ---      |
| 29 | I am an admin and there is database with medical records for different persons | I send a request to update existing medical record | The medical record is updated successfully and returned |
| 30 | I am an admin and there is database with medical records for different persons | I send a request to update non existing medical record | The medical record is not updated and meaningful message is returned | 

1. As an admin of the system, I want to be able to delete a medical record for a person, so I can 
remove incorrect records from the database.

| ID      | GIVEN      | WHEN      | THEN     |
| ---     | ---        | ---       | ---      |
| 31 | I am an admin and there is database with medical records for different persons | I send a request to delete an existing medical record | The medical record is deleted |
| 32 | I am an admin and there is database with medical records for different persons | I send a request to delete a non existing medical record | Nothing is deleted and meaningful message is returned |
  


