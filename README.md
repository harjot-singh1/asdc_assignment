# Code Labeller

Welcome to the Code Labeller This project is designed to allow annotators to add annotations to code snippets in the frontend, which are then reported to administrators. Additionally, we've implemented a Continuous Integration/Continuous Deployment (CI/CD) pipeline to automate code updates on the server whenever changes are committed to the main branch.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
    - [Running the Application](#running-the-application)
- [Usage](#usage)
- [Testing](#testing)
- [Contributing](#contributing)

## Features

- Annotators can:
  - Highlight and annotate code snippets.
  - Submit annotations.
- Administrators can:
  - Add Code Snippets and annotations
  - Tag annotations to the particular code
  - View annotation reports and add annotation to the code
- CI/CD Pipeline:
  - Automatically updates the server when changes are pushed to the main branch.

## Getting Started

### Prerequisites

To run this project, you'll need:

- Java Development Kit (JDK)
- Node.js
- npm (Node Package Manager)
- Your favorite IDE or code editor

### Installation

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/harjot-singh1/asdc_assignment.git
   ```

2. Navigate to the project directory:

   ```bash
   cd backend
   ```

3. Install the Java and React dependencies:

   ```bash
   # Install Java dependencies (if applicable)
   # Instructions for Java dependencies go here

   # Install React dependencies
   cd frontend
   npm install
   ```

### Running the Application

1. Start the Java backend (instructions for starting the Java application go here).

2. Start the React frontend:

   ```bash
   cd frontend
   npm start
   ```

3. Access the application in your web browser at `http://localhost:3000`.

## Usage

1. Annotator Usage:
    - Log in as an annotator.
    - Highlight and annotate code snippets.
    - Submit annotations.

2. Administrator Usage:
    - Log in as an admin.
    - View annotation reports.

## Testing

We've included test cases to ensure the reliability of our code. To run the tests, follow these steps:


## Contributing

We welcome contributions! If you'd like to contribute to this project, please follow these guidelines:

1. Fork the repository.
2. Create a new branch for your feature or bug fix: `git checkout -b feature/your-feature-name` or `git checkout -b bugfix/your-bugfix-name`.
3. Commit your changes and push to your forked repository.
4. Create a pull request with a detailed description of your changes.
