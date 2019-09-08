INSERT INTO trainingSet (text, category) VALUES
  ('Get upto 30% off', 'spam'),
  ('Product is good', 'ham'),
  ('Quality is nice', 'ham'),
  ('Get flat 40% off', 'spam');
  
  INSERT INTO wordFrequency (word, count, category) VALUES
  ('get', 2 , 'spam'),
  ('product', 1 , 'ham'),
  ('flat', 1, 'spam'),
  ('good', 1, 'ham'),
  ('upto', 1, 'spam'),
  ('is', 2, 'ham'),
  ('nice', 1, 'spam'),
  ('off', 2, 'spam');