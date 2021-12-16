Feature: File manipulation testing
@Upload
  Scenario Outline: Upload file
    Given User have file to upload with path <path>
    When User uploads file with name <fileName>
    Then User can get info on file with name <fileName>
    Examples:
      |path|fileName|
      |"hello.txt"|"hello.txt"|
@GetMetadata
  Scenario Outline: Get File Metadata
    Given File <fileName> is uploaded
    When User gets file metadata with name <fileName>
    Then User sees file metadata
    Examples:
      |fileName|
      |"hello.txt"|
 @Delete
 Scenario Outline: Delete file
   Given File <fileName> is uploaded
   When User deletes file with name <fileName>
   Then File is deleted
   Examples:
     |fileName|
     |"hello.txt"|



