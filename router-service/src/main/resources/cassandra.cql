CREATE TABLE cassandratransaction (
  id uuid,
  messageid text,
  status text,
  transactionid text,
  requestxml blob,
  responsexml blob,
  PRIMARY KEY ((id))
);

CREATE INDEX idxmessageid ON cassandratransaction (messageid);