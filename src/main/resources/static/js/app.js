var Application = (function () {
    var authorName = "";
    var blueprintsAuthor = [];
    var module = apiclient;

    function changeAuthorName(newName) {
        authorName = newName;
    }

    function createBlueprintRow(authorName, blueprint) {
        var row = $("<tr>");
        var name = $("<td>").text(blueprint.name);
        var points = $("<td>").text(blueprint.numberOfPoints);
        var button = $("<button>")
                    .text("Open")
                    .on("click", function() {
                        openBlueprint(authorName, blueprint.name);
                    });
        button.addClass("btn btn-outline-secondary");
        button.attr("type", "submit");
        var buttonAppend = $("<td>").append(button);
        row.append(name, points, buttonAppend);
        return row;
    }

    function updateBlueprint(authorName) {
        module.getBlueprintsByAuthor(authorName, function (blueprints) {
            var newBlueprints = blueprints.map(function (blueprints) {
                return {name: blueprints.name, numberOfPoints: blueprints.points.length};
            });
            var table = $("#table-blueprints");
            table.find("tr:not(:first)").remove();
            newBlueprints.forEach(function (blueprint) {
                var row = createBlueprintRow(authorName, blueprint);
                table.append(row);
            });
            var totalPoints = newBlueprints.reduce(function (total, blueprint) {
                return total + blueprint.numberOfPoints;
            }, 0);
            $("#total-points").text(totalPoints);
            $("#author").text(authorName + "'s blueprints:");
        });
    }

    function openBlueprint(authorName, blueprintName) {
        module.getBlueprintsByNameAndAuthor(authorName, blueprintName, function (blueprint) {
            var points = blueprint.points;
            var canvas = $("#canvas")[0];
            var context = canvas.getContext("2d");
            context.clearRect(0, 0, canvas.width, canvas.height);
            context.beginPath();
            for (var i = 0; i < points.length - 1; i++) {
                context.moveTo(points[i].x, points[i].y);
                context.lineTo(points[i+1].x, points[i+1].y);
                context.stroke();
            }
            $("#name-blueprint").text(blueprintName);
        });
    }

    return {
      changeAuthorName: changeAuthorName,
      updateBlueprint: updateBlueprint
    };
})();