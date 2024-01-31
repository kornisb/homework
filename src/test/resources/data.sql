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
	[id] INT PRIMARY KEY,
	[first_name] VARCHAR(255),
	[last_name] VARCHAR(255)
);

CREATE TABLE [dbo].[address](
	[id] INT PRIMARY KEY,
	[address] VARCHAR(255),
	[address_type] VARCHAR(255)
);

CREATE TABLE [dbo].[contact](
	[id] INT PRIMARY KEY,
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

INSERT INTO [dbo].[person]
           ([id]
           ,[first_name]
           ,[last_name])
     VALUES
           (1, 'Bence', 'Kornis'),
           (2, 'Cecilia', 'Tanos');
GO

INSERT INTO [dbo].[address]
           ([id]
           ,[address]
           ,[address_type])
     VALUES
           (1, '1116 Budapest, Kondorosi ut 8', 'Permanent'),
		   (2, '1117 Budapest, Hamzsabegi ut 8', 'Temporary'),
		   (3, '1117 Budapest, Hamzsabegi ut 8', 'Permanent');
GO

INSERT INTO [dbo].[contact]
           ([id]
           ,[contact]
           ,[contact_type])
     VALUES
           (1, '+36301399782', 'Phone'),
		   (2, 'kornisbence@gmail.com', 'Email'),
		   (3, '+36304397566', 'Phone'),
		   (4, 'tanoscili@gmail.com', 'Email');
GO

INSERT INTO [dbo].[person_addresses]
           ([person_id]
           ,[addresses_id])
     VALUES
           (1, 1),
		   (1, 2),
		   (2, 3);
GO

INSERT INTO [dbo].[person_contacts]
           ([person_id]
           ,[contacts_id])
     VALUES
           (1, 1),
		   (1, 2),
		   (2, 3),
		   (2, 4);
GO