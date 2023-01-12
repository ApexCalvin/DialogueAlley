INSERT INTO `DialogueAlley`.`account` (`first_name`, `handle`, `password`, `username`) VALUES ('Adam', 'Nyoxide', 'Adam', 'Adam');
INSERT INTO `DialogueAlley`.`account` (`first_name`, `handle`, `password`, `username`) VALUES ('Andrew', 'Scone', 'Andrew', 'Andrew');
INSERT INTO `DialogueAlley`.`account` (`first_name`, `handle`, `password`, `username`) VALUES ('Calvin', 'Apex', 'Calvin', 'Calvin');
INSERT INTO `DialogueAlley`.`account` (`first_name`, `handle`, `password`, `username`) VALUES ('John', 'DocHoliday', 'John', 'John');
INSERT INTO `DialogueAlley`.`post` (`message`, `account_id`) VALUES ('Hello!', '1');
INSERT INTO `DialogueAlley`.`post` (`message`, `account_id`) VALUES ('What\'s for dinner?', '1');
INSERT INTO `DialogueAlley`.`post` (`message`, `account_id`) VALUES ('I\'m so sleepy.', '2');
INSERT INTO `DialogueAlley`.`post` (`message`, `account_id`) VALUES ('How are you?', '2');
INSERT INTO `DialogueAlley`.`post` (`message`, `account_id`) VALUES ('I love Tacos!', '3');
INSERT INTO `DialogueAlley`.`post` (`message`, `account_id`) VALUES ('Batman or James Bond?', '3');
INSERT INTO `DialogueAlley`.`post` (`message`, `account_id`) VALUES ('ZipCode 4 Life', '4');
INSERT INTO `DialogueAlley`.`post` (`message`, `account_id`) VALUES ('Who\'s your favorite band?', '4');
INSERT INTO `DialogueAlley`.`comment` (`message`, `account_id`, `post_id`) VALUES ('Hi', '2', '1');
INSERT INTO `DialogueAlley`.`comment` (`message`, `account_id`, `post_id`) VALUES ('Hey There', '3', '1');
INSERT INTO `DialogueAlley`.`comment` (`message`, `account_id`, `post_id`) VALUES ('Yo', '4', '1');
INSERT INTO `DialogueAlley`.`comment` (`message`, `account_id`, `post_id`) VALUES ('Tacos!', '2', '2');
INSERT INTO `DialogueAlley`.`comment` (`message`, `account_id`, `post_id`) VALUES ('Chili', '3', '2');
INSERT INTO `DialogueAlley`.`comment` (`message`, `account_id`, `post_id`) VALUES ('Yummy!', '1', '2');
INSERT INTO `DialogueAlley`.`hashtag` (`hashtag`) VALUES ('Food');
INSERT INTO `DialogueAlley`.`hashtag` (`hashtag`) VALUES ('Media');
INSERT INTO `DialogueAlley`.`post_hashtag_xref` (`hashtag_id`, `post_id`) VALUES ('1', '2');
INSERT INTO `DialogueAlley`.`post_hashtag_xref` (`hashtag_id`, `post_id`) VALUES ('1', '5');
INSERT INTO `DialogueAlley`.`post_hashtag_xref` (`hashtag_id`, `post_id`) VALUES ('2', '6');
INSERT INTO `DialogueAlley`.`post_hashtag_xref` (`hashtag_id`, `post_id`) VALUES ('2', '8');

localhost:8080/post/searchHandle/Scone

localhost:8080/post/searchHashtag/Food

localhost:8080/comment/allComments/1

