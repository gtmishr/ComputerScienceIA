CREATE TABLE contractor (
    licenceID VARCHAR(100) NOT NULL PRIMARY KEY,
    licenceNumber VARCHAR(100) NOT NULL,
    businessNames VARCHAR(100) NOT NULL,
    categories VARCHAR(100) NOT NULL,
    classes VARCHAR(100) NOT NULL,
    licenceName VARCHAR(100) NOT NULL,
    licenceType VARCHAR(100) NOT NULL,
    licensee VARCHAR(100) NOT NULL,
   	postcode VARCHAR(100) NOT NULL,
   	status VARCHAR(100) NOT NULL,
   	suburb VARCHAR(100) NOT NULL
);