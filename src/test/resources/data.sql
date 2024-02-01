-- Use the master database
USE master;

-- Drop database if exists
IF EXISTS (SELECT 1 FROM sys.databases WHERE name = 'kornisbencedb')
    DROP DATABASE kornisbencedb;
GO

-- Create Database
CREATE DATABASE kornisbencedb;
GO

-- Use the created database
USE kornisbencedb;
GO

-- Drop login if exists
IF EXISTS (SELECT 1 FROM sys.server_principals WHERE name = 'kornisbence')
    DROP LOGIN kornisbence;

-- Create Login
CREATE LOGIN kornisbence WITH PASSWORD = '1234';

-- Drop user if exists
IF EXISTS (SELECT 1 FROM sys.database_principals WHERE name = 'kornisbence')
    DROP USER kornisbence;

-- Map the Login to the database
CREATE USER kornisbence FOR LOGIN kornisbence;

-- Grant Permissions
ALTER ROLE db_owner ADD MEMBER kornisbence;

GRANT ALTER, DELETE, EXECUTE, INSERT, REFERENCES, SELECT, UPDATE, VIEW DEFINITION TO kornisbence;

CREATE TABLE [dbo].[person](
	[id] INT PRIMARY KEY IDENTITY(1,1),
	[first_name] VARCHAR(255),
	[last_name] VARCHAR(255)
);

CREATE TABLE [dbo].[address](
    [id] INT PRIMARY KEY IDENTITY(1,1),
    [address] VARCHAR(255),
    [address_type] VARCHAR(255)
);

CREATE TABLE [dbo].[contact](
    [id] INT PRIMARY KEY IDENTITY(1,1),
    [contact] VARCHAR(255),
    [contact_type] VARCHAR(255)
);

CREATE TABLE [dbo].[person_addresses](
    [person_id] INT NOT NULL,
    [addresses_id] INT NOT NULL,
    CONSTRAINT [UK_person_addresses_addresses_id] UNIQUE NONCLUSTERED ([addresses_id]),
    CONSTRAINT [FK_person_addresses_address] FOREIGN KEY([addresses_id]) REFERENCES [dbo].[address] ([id]),
    CONSTRAINT [FK_person_addresses_person] FOREIGN KEY([person_id]) REFERENCES [dbo].[person] ([id])
);

CREATE TABLE [dbo].[person_contacts](
    [person_id] INT NOT NULL,
    [contacts_id] INT NOT NULL,
    CONSTRAINT [UK_person_contacts_contacts_id] UNIQUE NONCLUSTERED ([contacts_id]),
    CONSTRAINT [FK_person_contacts_person] FOREIGN KEY([person_id]) REFERENCES [dbo].[person] ([id]),
    CONSTRAINT [FK_person_contacts_contact] FOREIGN KEY([contacts_id]) REFERENCES [dbo].[contact] ([id])
);

-- Insert into 'person' table
INSERT INTO [dbo].[person]
           ([first_name]
           ,[last_name])
     VALUES
           ('Bence', 'Kornis'),
           ('Cecilia', 'Tanos');
GO

-- Insert into 'address' table
INSERT INTO [dbo].[address]
           ([address]
           ,[address_type])
     VALUES
           ('1116 Budapest, Kondorosi ut 8', 'Permanent'),
		   ('1117 Budapest, Hamzsabegi ut 8', 'Temporary'),
		   ('1117 Budapest, Hamzsabegi ut 8', 'Permanent');
GO

-- Insert into 'contact' table
INSERT INTO [dbo].[contact]
           ([contact]
           ,[contact_type])
     VALUES
           ('+36301399782', 'Phone'),
		   ('kornisbence@gmail.com', 'Email'),
		   ('+36304397566', 'Phone'),
		   ('tanoscili@gmail.com', 'Email');
GO

-- Insert into 'person_addresses' table
INSERT INTO [dbo].[person_addresses]
           ([person_id]
           ,[addresses_id])
     VALUES
           (1, 1),
		   (1, 2),
		   (2, 3);
GO

-- Insert into 'person_contacts' table
INSERT INTO [dbo].[person_contacts]
           ([person_id]
           ,[contacts_id])
     VALUES
           (1, 1),
		   (1, 2),
		   (2, 3),
		   (2, 4);
GO