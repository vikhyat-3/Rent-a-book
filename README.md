# Rent-a-book
This is a back-end application which is used to help people rent out books to those living in and around their neighbourhood.


## Dependencies
All dependencies are present in the pom.xml file.
However, I build this using MongoDB locally (not using ATLAS). So make sure you have mongod running on your system.

Update the DB configs in the application.properties file accordingly.

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

## Schema

User: ID, Name, Email, Password, Location

Books: ID, Name, Author, Published Year, Genre, Description

Author: ID, Name, Gender, Books[]


## License

[MIT](https://choosealicense.com/licenses/mit/)
