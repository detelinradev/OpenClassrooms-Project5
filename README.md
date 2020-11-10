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
| 1 | I am user and there is database with people living in certain area, serviced by specific fire station | I send a request with fire station number | A list is produced that consist of people's first, last name, address, phone number and summary of the number of adults in the service area, and summary of the number of the children | 
| 2 | I am user and there is database with no people living in certain area, serviced by specific fire station | I send a request with fire station number | An empty list is returned | 


2. As an emergency responder, I want to be able to get a list of children
(anyone under the age of 18) living at specific address including the first and 
last name of each child, the child's age, and a list of other people living at that
address, so I can look after them when an emergency situation arise at that address.

| ID      | GIVEN      | WHEN      | THEN     |
| ---     | ---        | ---       | ---      |
| 3 | I am a user and there is database with people living at specific address | I send a request with specific address | A list of children living at that address is produced that consists of first name, last name and the age of the child along with a list with other persons living at that address |
| 4 | I am a user and there is database with no children living at specific address | I send a request with specific address | An empty string is returned |

3. As an emergency responder, I want to be able to get a list of phone numbers of each
person within specific fire station's jurisdiction, so I can send emergency text 
messages to specific households.

1. As an emergency responder, I want to be able to get the fire station number that services 
a specific address, as well as a list of all the people living at the address that 
includes a name, phone number and age of all person, and any medications(with dosage) 
and allergies, so I can get help in an emergency situation as well to be able to 
allocate and help all people at that address.

1. As an emergency responder, I want to be able to get a list of all the households under 
the jurisdiction of all the fire station in a list with fire stations. The list needs to 
group people by household address, include a name, phone number and age of each person, 
and any medications(with dosage) and allergies beside each person's name, so I know in 
case of flood, whereabouts and how many people are in the endangered area.

1. As an emergency responder , I want to be able to get person's info by passing first name and 
last name as parameter, so I have the person's name, address, age, email, list of medications 
with dosages and allergies in case I need it.

1. As an emergency responder, I want to be able to get list with email addresses of all people 
in a city by passing specific city as parameter, so I can send emails to all in case of 
emergency.

1. As an admin of the system, I want to be able to add a new person to the system database, so 
the database can be updated when needed.

1. As an admin of the system, I want to be able to update a person's info, so the database can 
be updated when needed.

1. As an admin of the system, I want to be able to delete a person, so the database can be updated
when needed.

1. As an admin of the system, I want to able to add fire station/address mapping, so I can connect
fire station with address.

1. As an admin of the system, I want to be able to update an address's fire station number, so I
can keep the database updated with correct information.

1. As an admin of the system, I want to be able to delete fire station/address mapping, so I can
remove unnecessary mappings from the database.

1. As an admin of the system, I want to be able to add a medical record for a person, so I can keep 
person's info correct.

1. As an admin of the system, I want to be able to update a medical record for a person, so I can 
keep person's info updated.

1. As an admin of the system, I want to be able to delete a medical record for a person, so I can 
remove incorrect records from the database.
  


