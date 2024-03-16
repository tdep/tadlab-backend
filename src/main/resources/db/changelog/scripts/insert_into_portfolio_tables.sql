--changeset tdep:3

INSERT INTO portfolio_entries (entry_name, entry_type)
VALUES
    ('test-entry-1','PROJECT'),
    ('test-entry-2','LINK'),
    ('test-entry-2','LINK'),
    ('test-entry-2','TOOL'),
    ('test-entry-2','LINK'),
    ('test-entry-2','LINK');

INSERT INTO urls (url_name, url, entry_id)
VALUES
    ('tool-image-link-1', 'image-link.tadlab', 5),
    ('project-demo-link-2', 'image-link.tadlab', 6);

INSERT INTO projects (project_name, project_description, entry_id)
VALUES
    ('project-1', 'this is a project', 1);

INSERT INTO links (link_name, link_type, url_id, entry_id, project_id)
VALUES
    ('tool-link-1', 'IMAGE', 1, 2, 1),
    ('project-link-1', 'DEMO', 2, 3, 1);

INSERT INTO tools (tool_name, project_id, link_id, entry_id)
VALUES
    ('tool-1', 1, 1, 4);
