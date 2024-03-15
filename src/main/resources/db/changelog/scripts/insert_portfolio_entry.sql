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

