create table rivetlogic_hangouts_HangoutsGroup (
	hangoutsGroupId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	groupName VARCHAR(75) null,
	hangoutsContacts VARCHAR(75) null
);