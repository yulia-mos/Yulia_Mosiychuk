Feature: File manipulation testing
@Upload
  Scenario Outline: Upload file
    Given User have file to upload with path <path>
    When User uploads file with name <fileName>
    Then User can get info on file with name <fileName>
    Examples:
      |path|fileName|
      |"C:\\Labs\\DevelopTest\\text.txt"|"text.txt"|
@GetMetadata
  Scenario Outline: Get File Metadata
    Given File <fileName> is uploaded
    When User gets file metadata with name <fileName>
    Then User sees file metadata
    Examples:
      |fileName|
      |"text.txt"|
 @Delete
 Scenario Outline: Delete file
   Given File <fileName> is uploaded
   When User deletes file with name <fileName>
   Then File is deleted
   Examples:
     |fileName|
     |"text.txt"|



