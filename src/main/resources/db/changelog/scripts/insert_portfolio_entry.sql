--changeset tdep:3

INSERT INTO portfolio_entries (name, entry_type)
VALUES
('test-entry-1', 'PROJECT'),
('test-entry-2', 'PROJECT'),
('test-entry-3', 'PROJECT');

INSERT INTO urls (name, url, url_type)
VALUES
('project-demo-link-1', 'thisIsATest.tadlab', 'DEMO'),
('project-github-link-1', 'thisIsATest.tadlab', 'GITHUB'),
('project-image-link-1', 'thisIsATest.tadlab', 'IMAGE'),
('project-demo-link-2', 'thisIsATest.tadlab', 'DEMO'),
('project-image-link-2', 'thisIsATest.tadlab', 'IMAGE');

INSERT INTO portfolio_entry_urls (portfolio_entry_id, url_id)
VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 4),
(2, 5);

