# FeedListAssignment 

Overview
This exercise is used to assess technical proficiency, coding-style, library-awareness and approach.
It will be evaluated on both the code quality and the final product with equal weighting.

Specification

Create an Android app which:

1. Ingests a json feed from here.
<https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/facts.json>

2. Displays the content in a ListView 

• The title in the ActionBar should be updated from the json data.
• Each row should be dynamically sized to display its content, no clipping, no extraneous
white-space etc.

3. Loads the images lazily.

4. Allows the data/view to be refreshed, via either:

• A refresh button
• Pull down to refresh

Guidelines

1. Use Git to manage the source code. A clear history is required.
2. The app should target Android version 4.0. Don’t worry about backwards compatibility for this
task.
3. The list should scroll smoothly. As much work as possible should be cached.
4. Feel free to use any open-source libraries/examples you need, just be sure to give credit.
5. Comment your code where necessary.
6. Polish your code as much as possible.
Finally, each row of the table should look roughly like the following image.
