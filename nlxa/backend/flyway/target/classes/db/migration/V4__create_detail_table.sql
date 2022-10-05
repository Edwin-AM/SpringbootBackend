CREATE TABLE `detail`
(
    `detail_id` VARCHAR(50) NOT NULL,
    `invoice_id` VARCHAR(50) NOT NULL,
    `product_id` VARCHAR(50) NOT NULL,
    `item_amount` INT(11) NOT NULL,
    `price` INT(11) NOT NULL,
    PRIMARY KEY (`detail_id`),
    CONSTRAINT invoice FOREIGN KEY (`invoice_id`) REFERENCES invoice(`invoice_id`),
    CONSTRAINT product FOREIGN KEY (`product_id`) REFERENCES product(`product_id`)
);