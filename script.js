function showSection(id) {
    // Hide all sections
    const sections = document.querySelectorAll("section");
    sections.forEach(section => section.classList.add("hidden"));
    
    // Show the selected section
    const sectionToShow = document.getElementById(id);
    sectionToShow.classList.remove("hidden");
}

function hideSections() {
    // Hide all sections
    const sections = document.querySelectorAll("section");
    sections.forEach(section => section.classList.add("hidden"));
}
