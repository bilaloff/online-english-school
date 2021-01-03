const dropdownButton = document.getElementById('dropdown-button');
const dropdownMenu = document.getElementById('dropdown-menu');

window.addEventListener('load', () => {
    dropdownButton.addEventListener('click', toggleDropdown)
})


function toggleDropdown(e) {
    e.preventDefault();
    e.stopPropagation();
    if (dropdownMenu.classList.contains('show')) {
        hideDropdown();
    } else {
        document.addEventListener('click', hideDropdown, { once: true });
        dropdownMenu.classList.add('show');
    }
}

function hideDropdown() {
    dropdownMenu.classList.remove('show');
}

