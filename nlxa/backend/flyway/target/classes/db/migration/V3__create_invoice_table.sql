CREATE TABLE `invoice`
(
    `invoice_id` VARCHAR(50) NOT NULL,
    `client_id` VARCHAR(50) NOT NULL,
    `date` DATE NOT NULL,
    PRIMARY KEY (`invoice_id`),
    CONSTRAINT client FOREIGN KEY (`client_id`) REFERENCES client(`client_id`)
);