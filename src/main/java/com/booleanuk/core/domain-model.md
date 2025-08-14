

| **Class**  | **Members**                          | **Methods**                            | **Scenario**                                                                   | **Outputs**                |
| ---------- | ------------------------------------ | -------------------------------------- |--------------------------------------------------------------------------------|----------------------------|
| `TodoList` | `HashMap<String, Boolean> todoMap`   | `add(String name)`                     | Task is not in the list                                                        | `true`                     |
|            |                                      |                                        | Task with same name already exists                                             | `false`                    |
|            |                                      | `getAll()`                             | List contains tasks                                                            | `HashMap<String, Boolean>` |
|            |                                      | `getCompleted()`                       | Some tasks are marked as complete                                              | `HashMap<String, Boolean>` |
|            |                                      | `getIncomplete()`                      | Some tasks are incomplete                                                      | `HashMap<String, Boolean>` |
|            |                                      | `toggleStatus(String name)`            | Task with that name exists — changes from incomplete to complete or vice versa | `true` / `false`           |
|            |                                      | `search(String name)`                  | Task with that name exists                                                     | `"Task found"`              |
|            |                                      |                                        | Task does not exist                                                            | `"Task not found"`         |
|            |                                      | `remove(String name)`                  | Task removed from list                                                         | `true`                     |
|            |                                      |                                        | Task does not exist                                                            | `false`                    |
|            |                                      | `getAllAsc()`                          | Returns all tasks sorted by name A–Z                                           | `HashMap<String, Boolean>` |
|            |                                      | `getAllDesc()`                         | Returns all tasks sorted Z–A                                                   | `HashMap<String, Boolean>` |
