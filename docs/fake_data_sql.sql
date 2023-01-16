INSERT INTO `DialogueAlley`.`account` (`first_name`, `handle`, `password`, `username`) VALUES ('Adam', 'Nyoxide', 'Adam', 'Adam');
INSERT INTO `DialogueAlley`.`account` (`first_name`, `handle`, `password`, `username`) VALUES ('Andrew', 'Scone', 'Andrew', 'Andrew');
INSERT INTO `DialogueAlley`.`account` (`first_name`, `handle`, `password`, `username`) VALUES ('Calvin', 'Apex', 'Calvin', 'Calvin');
INSERT INTO `DialogueAlley`.`account` (`first_name`, `handle`, `password`, `username`) VALUES ('John', 'DocHoliday', 'John', 'John');
INSERT INTO `DialogueAlley`.`post` (`date_time`, `message`, `account_id`) VALUES ('2022-12-09 09:12:28.790000', 'Hello!', '1');
INSERT INTO `DialogueAlley`.`post` (`date_time`, `message`, `account_id`) VALUES ('2022-12-08 09:23:28.790000', 'What\'s for dinner?', '1');
INSERT INTO `DialogueAlley`.`post` (`date_time`, `message`, `account_id`) VALUES ('2022-12-09 10:25:28.790000', 'I\'m so sleepy.', '2');
INSERT INTO `DialogueAlley`.`post` (`date_time`, `message`, `account_id`) VALUES ('2022-12-14 10:36:28.790000', 'How are you?', '2');
INSERT INTO `DialogueAlley`.`post` (`date_time`, `message`, `account_id`) VALUES ('2022-12-12 12:45:28.790000', 'Rare earth elements are just common asteroid elements.', '3');
INSERT INTO `DialogueAlley`.`post` (`date_time`, `message`, `account_id`) VALUES ('2022-12-15 12:46:28.790000', 'Batman or James Bond?', '3');
INSERT INTO `DialogueAlley`.`post` (`date_time`, `message`, `account_id`) VALUES ('2022-12-13 13:52:28.790000', 'ZipCode 4 Life', '4');
INSERT INTO `DialogueAlley`.`post` (`date_time`, `message`, `account_id`) VALUES ('2022-12-15 13:28:28.790000', 'Who\'s your favorite band?', '4');
INSERT INTO `DialogueAlley`.`comment` (`date_time`, `message`, `account_id`, `post_id`) VALUES ('2023-01-09 01:42:28.790000', 'Hi', '2', '1');
INSERT INTO `DialogueAlley`.`comment` (`date_time`, `message`, `account_id`, `post_id`) VALUES ('2023-01-13 02:23:28.790000', 'Hey There', '3', '1');
INSERT INTO `DialogueAlley`.`comment` (`date_time`, `message`, `account_id`, `post_id`) VALUES ('2023-01-06 03:02:28.790000', 'Yo', '4', '1');
INSERT INTO `DialogueAlley`.`comment` (`date_time`, `message`, `account_id`, `post_id`) VALUES ('2023-01-14 04:31:28.790000', 'Tacos!', '2', '2');
INSERT INTO `DialogueAlley`.`comment` (`date_time`, `message`, `account_id`, `post_id`) VALUES ('2023-01-01 05:19:28.790000', 'Chili', '3', '2');
INSERT INTO `DialogueAlley`.`comment` (`date_time`, `message`, `account_id`, `post_id`) VALUES ('2023-01-12 06:21:28.790000', 'Yummy!', '1', '2');
INSERT INTO `DialogueAlley`.`hashtag` (`hashtag`) VALUES ('Food');
INSERT INTO `DialogueAlley`.`hashtag` (`hashtag`) VALUES ('Media');
INSERT INTO `DialogueAlley`.`post_hashtag_xref` (`hashtag_id`, `post_id`) VALUES ('1', '2');
INSERT INTO `DialogueAlley`.`post_hashtag_xref` (`hashtag_id`, `post_id`) VALUES ('1', '5');
INSERT INTO `DialogueAlley`.`post_hashtag_xref` (`hashtag_id`, `post_id`) VALUES ('2', '6');
INSERT INTO `DialogueAlley`.`post_hashtag_xref` (`hashtag_id`, `post_id`) VALUES ('2', '8');


localhost:8080/post/searchHandle/Scone

localhost:8080/post/searchHashtag/Food

localhost:8080/comment/allComments/1

