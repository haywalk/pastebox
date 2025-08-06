# Pastebox

This is a Pastebin clone written in Java using Spring.

## API Documentation

<dl>
    <dt>/api/paste</dt>
    <dd>PUT mapping for a new paste (content type application/String). Includes ID of new paste in response body.</dd>
    <dt>/api/retrieve?id=[ID]</dt>
    <dd>Returns contents of a paste (or an error).</dd>
</dl>

